package com.dy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@RestController
@RequestMapping("/api/user")
@Slf4j
public class Controller {

    private final List<User> userList = new CopyOnWriteArrayList<>();

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class UserDto {
        List<User> list = new ArrayList<>();

        static UserDto from(List<User> list) {
            UserDto dto = new UserDto();
            dto.list = list;
            return dto;
        }
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDto> hello() {
        return ResponseEntity.ok(UserDto.from(userList));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> create(@RequestBody User user) {
        userList.add(user);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        userList.removeIf(user -> user.getId() == id);
        log.info("Deleted user with id: {}", id);
        return ResponseEntity.ok().build();
    }

}

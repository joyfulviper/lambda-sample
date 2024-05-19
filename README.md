# AWS LAMBDA

- 참고 [1](https://docs.aws.amazon.com/ko_kr/serverless-application-model/latest/developerguide/what-is-sam.html), [2](https://catalog.workshops.aws/complete-aws-sam/en-US), [3](https://github.com/aws/serverless-java-container)
- sam cli 설치
- sam init 으로 적당한 예제 프로젝트 참고(template.yaml 파일 작성법)
- sam build 로 빌드
- sam local start-api --port ${포트번호} 로 로컬 api 테스트
- sam deploy --guided --profile ${개인 pc에 등록한 프로필} 로 배포(프로필 디폴트 값 있음)
# Java Lotto

- Last Update: 2022-12-28

## 코드 리뷰어를 위한 간략한 프로젝트 구조 설명
```
codesquad
  ├── Exceptions
    └── CustomException.java
  ├── InputManager
    ├── UserInputHandler.java
    └── UserInputHandlerImpl.java
  ├── Lotto
    ├── Lotto.java
    ├── LottoStat.java
    └── Prize.java
  ├── MainLottoGame.java
  └── Utility.java

```
Exceptions : 에러 클래스들은 담아두는 패키지
- CustomException - 에러 메세지를 보여주고, 죽을때 왜 죽었는지 표시하기 위한 Exception class

InputManage : 입력을 handling 하는 패키지
- UserInputHandler : 사용자 입력을 받기 위한 Interface
  - 사용자에게 입력받는 방법은 scanner, bufferedReader, streamReader 등등 다양함 그에 interface 사용
- UserInputHandlerImpl: UserInputHandler 구현체
  - java.util.Scanner 이용해서 구현을 진행함

Lotto : 로또 관련 기능들을 담당하는 패키지
- Lotto : 한장의 로또
- LottoStat : 로또들을 관리해서 통계를 뽑는 클래스
- Prize : 로또의 상금을 저장하고 있는 Enum

워킹 디렉토리
- MainLottoGame : 로또 게임을 실행하고, 로또 스텟에게 계산 수행을 시키는 메인 클래스
- Utility : 중간에 Validation check를 위한 모든 코드를 모은 class


## 코드 리뷰

* [텍스트와 이미지로 살펴보는 코드스쿼드의 온라인 코드 리뷰 과정](https://github.com/code-squad/codesquad-docs/blob/master/codereview/README.md)

* [동영상으로 살펴보는 코드스쿼드의 온라인 코드 리뷰 과정](https://youtube.com/watch?v=lFinZfu3QO0&si=EnSIkaIECMiOmarE)

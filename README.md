# Java Lotto

- Last Update: 2022-01-06


> 2개의 메인 메소드가 존재하고 있습니다.\
> Console 프로그램을 위해서는 ConsoleLottoGame의 main 함수를 실행해 주세요.\
> Visual 프로그램을 위해서는 VisualLottoGame의 main 함수를 실행해 주세요.

## 코드 리뷰어를 위한 간략한 프로젝트 구조 설명

```
codesquad
 ├── ConsoleLottoGame.java
 ├── VisualLottoGame.java
 ├── Exceptions
 │   └── CustomException.java
 ├── InputManager
 │   ├── AwtInputHandler.java
 │   ├── UserInputHandler.java
 │   └── ScannerInputHandler.java
 ├── Lotto
 │   ├── Lotto.java
 │   ├── LottoStat.java
 │   ├── Prize.java
 │   └── WinLotto.java
 ├── UI
 │   ├── Panels
 │   │   ├── CustomPanel.java
 │   │   ├── ResultShowPanel.java
 │   │   ├── SingleInputPanel.java
 │   │   └── WinNumberPanel.java
 │   └── WindowManager.java
 └── Utility.java


```


워킹 디렉토리
- ConsoleLottoGame : console 로또 게임을 실행하고, 로또 스텟에게 계산 수행을 시키는 메인 클래스
- VisualLottoGame : visual 로또 게임을 실행하고, 각각의 버튼에 대응하는 event로직이 있는 메인 클레스
- Utility : Validation check를 위한 모든 코드를 모은 class

Exceptions : 에러 클래스들은 담아두는 패키지
- CustomException - 에러 메세지를 보여주고, 죽을때 왜 죽었는지 표시하기 위한 Exception class

InputManage : 입력을 handling 하는 패키지
- UserInputHandler : 사용자 입력을 받기 위한 Interface
  - 사용자에게 입력받는 방법은 scanner, bufferedReader, streamReader 등등 다양함 그에 interface 사용
- ScannerInputHandler : UserInputHandler 구현체
  - java.util.Scanner 이용해서 구현을 진행함
- AwtInputHandler: UserInputHandler 구현체
  - 각 화면의 Button, Label, TextField 등등을 이용해 구현함

Lotto : 로또 관련 기능들을 담당하는 패키지
- Lotto : 한장의 로또
- LottoStat : 로또들을 관리해서 통계를 뽑는 클래스
- Prize : 로또의 상금을 저장하고 있는 Enum
- WinLotto : 당첨번호와 보너스 번호를 가지고 있는 클래스

UI : awt를 이용해 화면을 보여주기위한 클래스를 모아둔 패키지
- WindowsManager : 하나의창을 의미하며 여기서 판넬을 바꿔끼어 화면이 바뀜.
- Panels : 각 화면을 구성하기 위한 판넬들을 모아둔 패키지
  - CustomPanel : interface 클래스로 WindowManager가 판낼을 관리하기 위한 기본 인터페이스
  - ResultShowPanel : 결과화면을 보여주는 판넬로 텍스트 필드와 버튼만 존재.
  - SingleInputPanel : 하나의 입력창이 있는 판넬
  - WinNumberPanel : 하나의 긴 입력창과 하나의 짧은 입력창이 있는 판넬

## 코드 리뷰

* [텍스트와 이미지로 살펴보는 코드스쿼드의 온라인 코드 리뷰 과정](https://github.com/code-squad/codesquad-docs/blob/master/codereview/README.md)

* [동영상으로 살펴보는 코드스쿼드의 온라인 코드 리뷰 과정](https://youtube.com/watch?v=lFinZfu3QO0&si=EnSIkaIECMiOmarE)

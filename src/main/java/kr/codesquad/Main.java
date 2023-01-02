package kr.codesquad;

public class Main {

  public static void main(String[] args) {
    App app = new App(new Console(), new WinnerChecker(), new LottoFactory());
    app.run();
  }

}

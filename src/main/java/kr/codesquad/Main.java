package kr.codesquad;

public abstract class Main {

  public static void main(String[] args) {
    UserConsole userConsole = new UserConsole();
    MachineLotto machine = new MachineLotto(userConsole);
    UserLotto userLotto = new UserLotto(userConsole);
    LastLotto lastLotto = new LastLotto(userConsole);
    LottoGameImpl lottoGame = new LottoGameImpl(machine,userLotto,lastLotto);
    lottoGame.start();
  }
}
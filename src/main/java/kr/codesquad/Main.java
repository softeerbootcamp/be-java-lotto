package kr.codesquad;

public abstract class Main {

  public static void main(String[] args) {
    LottoMachine machine = new LottoMachine();
    User user = new User();
    LottoGameImpl lottoGame = new LottoGameImpl(machine,user);
    lottoGame.start();
  }
}
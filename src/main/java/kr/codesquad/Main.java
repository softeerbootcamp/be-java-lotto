package kr.codesquad;

public class Main {
    public static void main(String[] args) {
        LottoSystem lottoSystem = new LottoSystem();
        Lotto lotto = lottoSystem.buyLotto();
        lottoSystem.checkLotto(lotto);
    }
}
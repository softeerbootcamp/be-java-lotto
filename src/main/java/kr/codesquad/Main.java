package kr.codesquad;

public class Main {
    public static void main(String[] args) {
        LottoMachine lm = new LottoMachine(1000);
        Lotto lotto = lm.buyLotto();
        lm.printLottoList(lotto.getLottoList());

        LottoChecker lc = new LottoChecker();
        lc.checkLotto(lotto);
    }
}
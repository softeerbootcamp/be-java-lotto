package kr.codesquad;

public class Main {
    public static void main(String[] args) {
        UserInput ui = new UserInput();
        LottoMachine lm = new LottoMachine(ui.inputMoney());
        Lotto lotto = lm.buyLotto();

        LottoChecker lc = new LottoChecker();
        lc.checkLotto(lotto, ui.inputBonusNum(ui.inputWinNum()));
    }
}
package kr.codesquad;

public class Main {
    public static void main(String[] args) {
        Money money = LottoInput.enterMoney();
        LottoGame game = new LottoGame(money);
        LottoOutput.printLottos(game);
        WinningLotto winningLotto = new WinningLotto(LottoInput.enterWinLottoNumber(), LottoInput.enterBonus());
        LottoResult lottoResult = game.match(winningLotto);
        LottoOutput.printResult(lottoResult, money.calProfitRate(lottoResult.calPrize()));
    }
}
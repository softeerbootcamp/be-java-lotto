package kr.codesquad.Model;

import java.util.List;

public class LottoGame {
    private List<Lotto> lottoBuyList;

    public LottoGame(Money money){
        LottosGenerator lottosGenerator = new AutoLottoGenerator();
        this.lottoBuyList = lottosGenerator.generate(money);
    }

}

package kr.codesquad.Model;

import java.util.List;

public class LottoGame {
    private final List<Lotto> lottoBuyList;

    public LottoGame(Money money){
        LottosGenerator lottosGenerator = new AutoLottoGenerator();
        this.lottoBuyList = lottosGenerator.generate(money);
    }

    public List<Lotto> getLottoBuyList(){
        return lottoBuyList;
    }


    public LottoResult match(WinningLotto winningLotto) {
        DefaultLottoResult result = new DefaultLottoResult();
        for(Lotto lotto : lottoBuyList){
            result.putRank(winningLotto.match(lotto));
        }
        return result;
    }
}

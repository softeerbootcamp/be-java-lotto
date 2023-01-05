package kr.codesquad;

import java.util.List;

public class LottoGame {
    private final List<Lotto> lottos;
    private LottosGenerator generator;
    public LottoGame(Money money) {
        this.generator = new AutoLottosGenerator();
        this.lottos = this.generator.generate(money);
    }
    public LottoResult match(WinningLotto winningLotto) {
        LottoResult result = new LottoResult();
        for (Lotto lotto : lottos) {
            result.putRank(winningLotto.match(lotto));
        }
        return result;
    }
    @Override
    public String toString(){
        String s="";
        for(Lotto lotto: lottos){
            s += lotto.toString() +"\n";
        }
        return s;
    }
}

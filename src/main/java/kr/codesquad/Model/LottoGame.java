package kr.codesquad.Model;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private final List<Lotto> lottoBuyList;

    public LottoGame(int autoLottoCount, int manualLottoCount, List<Lotto> manualLottoList){
        lottoBuyList = new ArrayList<>();
        generateAutoLotto(autoLottoCount);
        generateManualLotto(manualLottoCount, manualLottoList);
    }
    public void generateAutoLotto(int autoLottoCount){
        LottosGenerator lottosGenerator = new AutoLottoGenerator(autoLottoCount);
        this.lottoBuyList.addAll(lottosGenerator.generate());
    }

    public void generateManualLotto(int manualLottoCount, List<Lotto> manualLottoList){
        LottosGenerator lottosGenerator = new ManualLottoGenerator(manualLottoCount, manualLottoList);
        this.lottoBuyList.addAll(lottosGenerator.generate());
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

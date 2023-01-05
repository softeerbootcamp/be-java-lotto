package kr.codesquad.LottoManager;

import kr.codesquad.EmptyLotto;
import kr.codesquad.UserMenu.UserLotto;
import kr.codesquad.Utility;

import java.util.List;

public class LottoGenerator {
    private Utility utility;
    public void autoGenerate(UserLotto userLotto){
        utility = new Utility();
        for(int i=0;i< userLotto.getUserAllLottoCount()- userLotto.getUserManualLottoCount();i++){
            EmptyLotto emptyLotto = new EmptyLotto(utility.retRandLottoNum());
            userLotto.getUserLottoList().add(emptyLotto);
            emptyLotto.printNumbers();
        }
    }
    public void manualGenerate(List<EmptyLotto> userLottoList){


    }
}

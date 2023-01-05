package kr.codesquad.LottoManager;

import kr.codesquad.CustomException;
import kr.codesquad.InputHandler;
import kr.codesquad.User.UserInput;
import kr.codesquad.User.UserLotto;
import kr.codesquad.Utility;

public class LottoGenerator extends UserInput{
    private Utility utility;
    private InputHandler inputHandler;
    public void autoGenerate(UserLotto userLotto){
        for(int i=0;i< userLotto.getUserAllLottoCount()- userLotto.getUserManualLottoCount();i++){
            EmptyLotto emptyLotto = new EmptyLotto(utility.retRandLottoNum());
            userLotto.getUserLottoList().add(emptyLotto);
            emptyLotto.printNumbers();
        }
    }
    public void manualGenerate(UserLotto userLotto) throws CustomException {
        userLotto.setUserManualLottoCount();
        userInputManual();
    }
}

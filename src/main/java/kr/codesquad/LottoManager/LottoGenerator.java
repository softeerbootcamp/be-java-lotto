package kr.codesquad.LottoManager;

import kr.codesquad.CustomException;
import kr.codesquad.InputHandler;
import kr.codesquad.User.UserInput;
import kr.codesquad.User.UserLotto;
import kr.codesquad.Utility;

public class LottoGenerator extends UserInput{
    // 유틸리티나 인풋 핸들러들을 일일이 계속 선언해주고있는데, 개선 하고 싶음. user inputt
    // 상속받는거도 걸림.
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

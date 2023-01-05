package kr.codesquad.User;

import kr.codesquad.CustomException;
import kr.codesquad.LottoManager.EmptyLotto;

import java.util.List;

public class UserLotto {

    private int userAllLottoCount;
    private int userManualLottoCount;
    private List<EmptyLotto> userLottoList;
    private int[] prizeResults = {0, 0, 0, 0, 0};
    private UserInput userInput;
    public UserLotto() {
    }

    public void addPrizeResultsByIndex(int index) {
        this.prizeResults[index]++;
    }

    public int getUserAllLottoCount() {
        return this.userAllLottoCount;
    }

    public int getUserManualLottoCount() {
        return this.userManualLottoCount;
    }
    public List<EmptyLotto> getUserLottoList() {
        return this.userLottoList;
    }

    public void setUserManualLottoCount() throws CustomException {
        this.userManualLottoCount = userInput.userHowManyManual();
    }
}

package kr.codesquad.User;

import kr.codesquad.CustomException;
import kr.codesquad.LottoManager.EmptyLotto;

import java.util.List;

public class UserLotto {

    private static int userAllLottoCount;
    private static int userManualLottoCount;
    private List<EmptyLotto> userLottoList;
    private int[] prizeResults = {0, 0, 0, 0, 0};
    private static UserInput userInput;
    public UserLotto(int userAllLottoCount) {
        userInput = new UserInput();
        setUserAllLottoCount(userAllLottoCount);
    }

    public void addPrizeResultsByIndex(int index) {
        this.prizeResults[index]++;
    }

    public int[] getPrizeResults() {
        return prizeResults;
    }

    public void setUserAllLottoCount(int userAllLottoCount) {
        this.userAllLottoCount = userAllLottoCount;
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

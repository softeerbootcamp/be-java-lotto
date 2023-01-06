package kr.codesquad.User;

import kr.codesquad.CustomException;
import kr.codesquad.LottoManager.LottoPaper;

import java.util.ArrayList;
import java.util.List;

public class UserLotto {

    private static int userAllLottoCount;
    private static int userManualLottoCount;
    private List<LottoPaper> userLottoList;
    private int[] prizeResults = {0, 0, 0, 0, 0};
    private UserInput userInput;

    public UserLotto(int userAllLottoCount) {
        userInput = new UserInput();
        userLottoList = new ArrayList<>();
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

    public List<LottoPaper> getUserLottoList() {

        return this.userLottoList;
    }

    public void setUserManualLottoCount() {
        this.userManualLottoCount = userInput.userHowManyManual();
    }
    public void printUserLotto() {
        System.out.printf("수동으로 %d장, 자동으로 %d개를 구매했습니다.\n", userManualLottoCount, userAllLottoCount-userManualLottoCount);
        for (LottoPaper e : userLottoList) {
            e.printNumbers();
        }
    }

}

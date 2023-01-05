package kr.codesquad;

import kr.codesquad.LottoManager.EmptyLotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static kr.codesquad.Enum.Lotto_Info.LOTTO_SIZE;

public class Jackpot_Handler {
    public static final int[] PRIZE_CNT = {0, 0, 0, 0, 0};
    public static List<Integer> JACKPOT_NUM;
    public static int JACKPOT_BONUS_NUM = 0;

    public static boolean isJackpotBonusCorrect(List<Integer> my) {
        if (my.contains(JACKPOT_BONUS_NUM)) {
            return true;
        } else return false;
    }

    public int isMyLottoContainsJackpots(int i, List<Integer> my, List<Integer> jk) {
        if (my.contains(jk.get(i))) {
            return 1;
        } else {
            return 0;
        }
    }

    public void countingJackpots(List<Integer> my, List<Integer> jk) {
        int cnt = 0;
        for (int i = 0; i < LOTTO_SIZE.getValue(); i++) {
            cnt += isMyLottoContainsJackpots(i, my, jk);
        }
        if (cnt == 5 && isJackpotBonusCorrect(my)) {
            PRIZE_CNT[cnt - 2]++;
        } else if (cnt == 6) {
            PRIZE_CNT[cnt - 2]++;
        } else if (cnt >= 3) {
            PRIZE_CNT[cnt - 3]++;
        }
        ;
    }

    public void searchJackpotsInMyLottoList(GenerateMyLottoByCount myLottoByCount) {
        for (EmptyLotto o : myLottoByCount.getLottoList()
        ) {
            List<Integer> eachLotto = o.getNumbers();
            countingJackpots(eachLotto, JACKPOT_NUM);
        }
    }

    public void setJackpotNum() throws CustomException {
        InputHandler inputHandler = new InputHandler();
        System.out.printf("당첨 번호를 입력해 주세요.\n");
        String str = inputHandler.getStringInput();
        String[] strArr = str.split(",");
        JACKPOT_NUM = new ArrayList<>(LOTTO_SIZE.getValue());
        for (int i = 0; i < LOTTO_SIZE.getValue(); i++) {
            JACKPOT_NUM.add(Integer.parseInt(strArr[i]));
        }
        Collections.sort(JACKPOT_NUM);

    }

    public void setBonusNum() throws CustomException {
        InputHandler inputHandler = new InputHandler();
        System.out.printf("보너스 번호를 입력해 주세요.\n");
        int bonus = inputHandler.getIntegerInput();
        if (JACKPOT_NUM.contains(bonus)) {
            throw new CustomException("보너스 번호는 원개 번호들과 중복돠어선 안된다.");
        }
        JACKPOT_BONUS_NUM = bonus;
    }
}

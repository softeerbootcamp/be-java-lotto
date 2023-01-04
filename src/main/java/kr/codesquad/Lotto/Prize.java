package kr.codesquad.Lotto;

import java.util.List;

public enum Prize {
    FIRST(2000000000), SECOND(3000000), THIRD(1500000), FORTH(50000), FIFTH(5000), NOTHING(0);
    private static final Prize[] prizes = {NOTHING, NOTHING, NOTHING, FIFTH, FORTH, THIRD, FIRST};

    private final int money;

    Prize(int initMoney) {
        money = initMoney;
    }

    public int getMoney() {
        return money;
    }


    public static Prize calcPrize(WinLotto winning, Lotto lotto) {
        int count = 0;
        for (Integer expect_no : lotto.getLottoNums()) {
            count = countUpIfContains(winning.getLottoNums(), expect_no, count);
        }

        boolean isBonusCorrect = lotto.getLottoNums().contains(winning.getBonusNo());
        if (count == 5 && isBonusCorrect)
            return SECOND;
        return prizes[count];
    }

    public static int countUpIfContains(List<Integer> arr, int target, int count) {
        if (arr.contains(target))
            count += 1;
        return count;
    }
}

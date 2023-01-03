package kr.codesquad;

import java.util.Arrays;

public class Lotto {
    private static int bonus = -1;
    Integer[] num = new Integer[6];
    boolean winLotto = false;

    Lotto(int[] lottoNum) {
        for (int i = 0; i < 6; i++)
            num[i] = lottoNum[i];
        Arrays.sort(num);
    }

    Lotto(int[] lottoNum, boolean winLotto) {
        this(lottoNum);
        this.winLotto = winLotto;
    }

    public boolean bonusMatch() {
        return Arrays.asList(num).contains(bonus);
    }

    public static void setBonus(int bonus) {
        if (bonus <= 0 || bonus > 45) {
            System.out.println("Wrong Bonus Number");
            System.exit(1);
        }
        Lotto.bonus = bonus;
    }

    public void print() {
        System.out.print("[");
        for (int i = 0; i < 5; i++)
            System.out.print(num[i] + ", ");
        System.out.println(num[5] + "]");
    }
}

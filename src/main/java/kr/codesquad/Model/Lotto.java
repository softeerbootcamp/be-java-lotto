package kr.codesquad.Model;

import java.util.Arrays;

<<<<<<< HEAD
import java.util.List;

public class Lotto {
    public static final int LOTTO_NUM_LENGTH = 6;
    public static final int LOTTO_START_NUM = 1;
    public static final int LOTTO_END_NUM = 45;
    public static int bonus = -1;  //  bonus 숫자, Lotto 클래스를 상속받은 당첨로또 클래스로 수정예정
    public Integer[] num = new Integer[LOTTO_NUM_LENGTH];

    Lotto(List<Integer> lottoNum) {
        for (int i = 0; i < LOTTO_NUM_LENGTH; i++)
            num[i] = lottoNum.get(i);
        Arrays.sort(num);
    }


=======
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
>>>>>>> 1a9bb7d (conflict로 인한 복구)

    public boolean bonusMatch() {
        return Arrays.asList(num).contains(bonus);
    }

    public static void setBonus(int bonus) {
<<<<<<< HEAD

        if (bonus < LOTTO_START_NUM || bonus > LOTTO_END_NUM) {

=======
        if (bonus <= 0 || bonus > 45) {
>>>>>>> 1a9bb7d (conflict로 인한 복구)
            System.out.println("Wrong Bonus Number");
            System.exit(1);
        }
        Lotto.bonus = bonus;
    }

<<<<<<< HEAD

    //print함수 view로 옮겨야 함.

=======
>>>>>>> 1a9bb7d (conflict로 인한 복구)
    public void print() {
        System.out.print("[");
        for (int i = 0; i < 5; i++)
            System.out.print(num[i] + ", ");
        System.out.println(num[5] + "]");
    }
}

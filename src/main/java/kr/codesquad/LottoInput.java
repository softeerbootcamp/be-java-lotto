package kr.codesquad;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static kr.codesquad.Money.MONEY_PER_LOTTO;

public class LottoInput {
    private static final Scanner sc = new Scanner(System.in);
    public static Money enterMoney(){
        System.out.println("구입금액을 입력해주세요.");
        int money = Integer.parseInt(sc.nextLine());
        System.out.println(money / MONEY_PER_LOTTO + "개를 구매했습니다.");
        return new Money(money);
    }

    public static Lotto enterWinLottoNumber(){
        System.out.println("\n당첨 번호를 입력해주세요.");
        return enterLotto();
    }
    public static Lotto enterLotto(){
        List<String> s = Arrays.asList(sc.nextLine().replaceAll(" ", "").split(","));
        List<Integer> nums = s.stream().map(Integer::parseInt).collect(Collectors.toList());
        return new Lotto(nums);
    }
    public static int enterBonus(){
        System.out.println("보너스 볼을 입력해주세요.");
        return Integer.parseInt(sc.nextLine());
    }
}

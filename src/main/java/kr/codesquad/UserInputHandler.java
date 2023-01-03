package kr.codesquad;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class UserInputHandler {

    // lower bound and upper_bound are included in available range
    public static int getOneNumber( int lower_bound, int upper_bound){
        Scanner s1 = new Scanner(System.in);
        int userinput;
        userinput = s1.nextInt();
        if(userinput < lower_bound || userinput > upper_bound){
            throw new IllegalArgumentException();
        }
        return userinput;
    }
    public static int getMoney(){
        System.out.println("구입금액을 입력해 주세요.");
        int money = getOneNumber(0, Integer.MAX_VALUE);
        if (money % 1000 != 0)
            throw new IllegalArgumentException();
        return money;
    }

    public static ArrayList<Integer> getWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        Scanner s1 = new Scanner(System.in);
        List<String> nums = List.of(s1.nextLine().split(","));
        ArrayList<Integer> winningNumber = new ArrayList<>();
        for(String num : nums){
            winningNumber.add(Integer.parseInt(num.trim()));
        }
        if(winningNumber.size() != 6)
            throw new IllegalArgumentException();
        return winningNumber;
    }

    public static int getBonusNumber(List<Integer> winningNumbers) {
        System.out.println("보너스 볼을 입력해 주세요.");
        int bonus = getOneNumber(1, 45);
        if(winningNumbers.contains(bonus))
            throw new IllegalArgumentException();
        return bonus;
    }
}

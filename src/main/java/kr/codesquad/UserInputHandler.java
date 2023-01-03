package kr.codesquad;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class UserInputHandler {

    public static int getOneNumber( int lower_bound, int upper_bound){
        Scanner s1 = new Scanner(System.in);

        int money;
        money = s1.nextInt();
        if(money % 1000 != 0 || money < lower_bound || money > upper_bound){
            throw new IllegalArgumentException();
        }
        return money;
    }
    public static int getMoney(){
        System.out.println("구입금액을 입력해 주세요.");
        return getOneNumber(0, Integer.MAX_VALUE);
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
}

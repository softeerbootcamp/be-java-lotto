package kr.codesquad;

import java.util.Scanner;
public class UserInputHandler {

    public static int getMoney(){
        Scanner s1 = new Scanner(System.in);
        int money =0;
        while(true){
            System.out.print("구입금액을 입력해 주세요.");
            try {
                money = s1.nextInt();
                if(money % 1000 != 0 || money < 0){
                    throw new IllegalStateException();
                }
                return money;
            }
            catch(Exception e){
                System.out.println("0이상의 숫자를 1000단위로 입력해 주세요. 올바른 숫자형태를 입력해 주세요.");
            }
        }

    }
}

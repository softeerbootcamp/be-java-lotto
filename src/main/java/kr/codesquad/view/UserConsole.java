package kr.codesquad.view;

import kr.codesquad.model.UserInfo;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UserConsole {

    private static Scanner scan;
    private UserInfo user;

    public UserConsole(UserInfo user){
        this.user = user;
        scan = new Scanner(System.in);
    }

    //구매 금액 입력
    public int enterPurchasePrice(){
        Scanner scan = new Scanner(System.in);
        int purchasedPrice = 0;
        System.out.println("구입 금액을 입력해 주세요.");
        try{
            purchasedPrice = scan.nextInt();
        }catch (InputMismatchException e){
            enterPurchasePrice();
        }
        return purchasedPrice;
    }

    public int enterSudongLottoNumber(){
        Scanner scan = new Scanner(System.in);

        System.out.println("수동으로 구매할 로또 수를 입력해 주세요");
        int numOfLottoSudong = scan.nextInt();
        return numOfLottoSudong;
    }


    public String enterSudongLottoList(){
        Scanner scan = new Scanner(System.in);
        System.out.println("수동으로 구매할 로또 번호를 입력해주세요.");
        ArrayList<String> resultList = new ArrayList<>();
        String numStr = scan.nextLine();
        return numStr;
    }

    public String enterResultList(){
        Scanner scan = new Scanner(System.in);

        System.out.println("\n당첨 번호를 입력해 주세요.");
        String numStr = scan.nextLine();
        return numStr;
    }

    public int enterBonusNum(){
        Scanner scan = new Scanner(System.in);

        System.out.println("보너스볼을 입력해 주세요.");
        int givenBonusNum = scan.nextInt();
        return givenBonusNum;
    }

}

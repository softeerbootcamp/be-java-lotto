package kr.codesquad.view;

import kr.codesquad.exception.InputFormatException;
import kr.codesquad.exception.InputRangeException;
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
            purchasedPrice = scan.nextInt();}
        catch (InputMismatchException e){
            throw new InputFormatException("구입 금액의 형식은 정수형으로 작성하셔야 합니다");}
        if(purchasedPrice < 1000)
            throw new InputRangeException("구입 금액은 1000원 이상이어야 합니다.");
        return purchasedPrice;
    }

    public int enterSudongLottoNumber(){
        Scanner scan = new Scanner(System.in);
        int numOfLottoSudong = 0;
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요");
        try{
            numOfLottoSudong = scan.nextInt();}
        catch (InputMismatchException e){
            throw new InputFormatException("구입 금액의 형식은 정수형으로 작성하셔야 합니다");}
        if(numOfLottoSudong < 0)
            throw new InputRangeException("구입 금액은 0개 이상이어야 합니다");
        return numOfLottoSudong;
    }


    public String enterSudongLottoList(){
        Scanner scan = new Scanner(System.in);
        System.out.println("수동으로 구매할 로또 번호를 입력해주세요.");
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
        int givenBonusNum = 0;
        System.out.println("보너스볼을 입력해 주세요.");
        try{
            givenBonusNum = scan.nextInt();}
        catch (InputMismatchException e){
            throw new InputFormatException("보너스볼은 정수형으로 입력하셔야 합니다");}
        if(givenBonusNum <= 0 || givenBonusNum > 45)
            throw new InputRangeException("보너스볼은 1이상 45이하의 자연수여야 합니다.");
        return givenBonusNum;
    }

}

package kr.codesquad.View;

import java.math.BigInteger;
import java.util.Scanner;

public class LottoScanner {
    public BigInteger setMoney() {
        try{
            Scanner sc = new Scanner(System.in);
            BigInteger money = sc.nextBigInteger();
            return money;
        } catch (Exception e){
            System.out.println("error");
            System.exit(1);
            return null;
        }
    }

    public String scanWinNum(){
        Scanner sc = new Scanner(System.in);
        String winStr = sc.nextLine();
        return winStr;
    }
}

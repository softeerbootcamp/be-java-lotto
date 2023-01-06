package kr.codesquad.View;

import kr.codesquad.Exception.MoneyValidator;
import kr.codesquad.Model.Lotto;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class LottoScanner {

    public BigInteger scanMoney() {
        while (true) {
            try {
                Scanner sc = new Scanner(System.in);
                String moneyStr = sc.nextLine();
                MoneyValidator.isValid(moneyStr);
                System.out.println(moneyStr);
                return new BigInteger(moneyStr);
            } catch (NumberFormatException e) {
                System.out.println("Money should be Integer");
            }
        }
    }

    public List<Integer> scanLottoNumbers() {
        Scanner sc = new Scanner(System.in);
        try {
            String winStr = sc.nextLine();
            List<Integer> winNum = new ArrayList();
            String[] winStrArr = winStr.split(",");
            for(int i = 0; i < Lotto.LOTTO_NUM_LENGTH; ++i) {
                winNum.add(Integer.parseInt(winStrArr[i].trim()));
            }
            return winNum;
        }catch (Exception e){
            System.out.println("LottoNumber Input Error");
            e.printStackTrace();
            System.exit(0);
            return null;
        }
    }

    public int scanBonus() {
        Scanner sc = new Scanner(System.in);
        try {
            return sc.nextInt();
        }
        catch (Exception e){
            System.out.println("Wrong Bonus Input");
            e.printStackTrace();
            System.exit(0);
            return -1;
        }
    }

    public int scanManualAmount(){
        Scanner sc = new Scanner(System.in);
        try{
            return sc.nextInt();
        }catch (Exception e){
            System.out.println("Wrong manual count input");
            e.printStackTrace();
            System.exit(0);
            return -1;
        }
    }

}

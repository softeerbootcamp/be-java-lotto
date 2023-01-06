package kr.codesquad.View;

import kr.codesquad.Model.Lotto;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class LottoScanner {

    public BigInteger scanMoney() {
        try {
            Scanner sc = new Scanner(System.in);
            BigInteger money = sc.nextBigInteger();
            System.out.println(money);
            return money;
        } catch (InputMismatchException iee) {
            System.out.println("Money should be Integer");
            System.exit(0);
            return null;
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

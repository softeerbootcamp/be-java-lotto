package kr.codesquad.View;

import kr.codesquad.Exception.Validator;
import kr.codesquad.Model.Lotto;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LottoScanner {

    public BigInteger scanMoney() {
        while (true) {
            try {
                Scanner sc = new Scanner(System.in);
                String moneyStr = sc.nextLine();
                Validator.isValidMoney(moneyStr);
                System.out.println(moneyStr);
                return new BigInteger(moneyStr);
            } catch (NumberFormatException e) {
                System.out.println("Money should be Positive Integer");
            }
        }
    }

    public List<Integer> scanLottoNumbers() {
        while(true){
            try {
                Scanner sc = new Scanner(System.in);
                String[] winStrArr = parseLottoNumbers(sc.nextLine());
                Validator.isValidLottoNumbers(winStrArr);
                return getLottoNumbersList(winStrArr);
            } catch (NumberFormatException ne){
                System.out.println("You should only enter number");
            } catch (IllegalArgumentException iae){
                System.out.println("Enter 6 numbers");
            } catch (Exception e){
                System.out.println("LottoNumber Input Error");
            }
        }
    }

    private String[] parseLottoNumbers(String winStr){
        if (winStr.contains(","))
            return winStr.split(",");
        return winStr.split(" ");
    }

    private List<Integer> getLottoNumbersList(String[] winStrArr){
        List<Integer> winNum = new ArrayList<>();
        for(int i = 0; i < Lotto.LOTTO_NUM_LENGTH; ++i) {
            winNum.add(Integer.parseInt(winStrArr[i].trim()));
        }
        return winNum;
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

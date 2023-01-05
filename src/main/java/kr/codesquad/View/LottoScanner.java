package kr.codesquad.View;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LottoScanner {
    public BigInteger scanMoney() {
        try{
            Scanner sc = new Scanner(System.in);
            BigInteger money = sc.nextBigInteger();
            return money;
<<<<<<< HEAD
        } catch (Exception e){
=======
        } catch (Exception e) {
>>>>>>> cbaed76 (변수명 변경 및 코드 정리)
            System.out.println("error");
            System.exit(1);
            return null;
        }
    }

    public List<Integer> scanWinNum(){
        Scanner sc = new Scanner(System.in);
        String winStr = sc.nextLine();
        List<Integer> winNum = new ArrayList<>();
        String[] winStrArr = winStr.split(",");
        for (int i=0; i<6; i++)
            winNum.add(Integer.parseInt(winStrArr[i].trim()));
        return winNum;
    }
    public int scanBonus(){
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }
}

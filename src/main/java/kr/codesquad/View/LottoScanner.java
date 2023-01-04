package kr.codesquad.View;

<<<<<<< HEAD
=======
import kr.codesquad.Model.LottoService;

>>>>>>> 1a9bb7d (conflict로 인한 복구)
import java.math.BigInteger;
import java.util.Scanner;

public class LottoScanner {
    public BigInteger setMoney() {
<<<<<<< HEAD
=======
        System.out.println("구입금액을 입력해 주세요.");
>>>>>>> 1a9bb7d (conflict로 인한 복구)
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

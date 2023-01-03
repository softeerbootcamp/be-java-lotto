package kr.codesquad;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        User person = new User();

        System.out.println("구입 금액을 입력하세요");
        person.setCash(sc.nextInt());
        person.CalculateBuyNum();
        System.out.printf("구매 개수는 %d개입니다.\n", person.getBuyNum());
        person.MakeRandomLottoTickets();

        for(int i = 0; i < person.getBuyNum(); i++)
        {
            System.out.println(person.getLottoTickets().get(i));
        }

        LottoMachine lottoMachine = new LottoMachine();

        System.out.println();
        System.out.println("당첨 번호를 입력해주세요");
        ArrayList<Integer> winNums = new ArrayList<Integer>();
        for(int i = 0; i < 6; i++)
        {
            winNums.add(sc.nextInt());
        }
        lottoMachine.setWinNums(winNums);

        System.out.println("보너스 볼을 입력해주세요");
        lottoMachine.setBonusBall(sc.nextInt());

        ArrayList<Integer> result = lottoMachine.GetResult(person.getLottoTickets());
        person.PrintResult(result);
    }
}

enum LottoStatus{
    Fifth("3개 일치", 5000),
    Fourth("4개 일치", 50000),
    Third("5개 일치", 1500000),
    Second("5개 일치, 보너스 볼 일치", 30000000),
    First("6개 일치", 2000000000);

    LottoStatus(String val1, int val2)
    {
        setStatusValue1(val1);
        setStatusValue2(val2);
    }

    private String StatusValue1; // 상태메시지
    private int StatusValue2; // 당첨금액

    public String getStatusValue1() {
        return StatusValue1;
    }

    public void setStatusValue1(String statusValue1) {
        StatusValue1 = statusValue1;
    }

    public int getStatusValue2() {
        return StatusValue2;
    }

    public void setStatusValue2(int statusValue2) {
        StatusValue2 = statusValue2;
    }

}
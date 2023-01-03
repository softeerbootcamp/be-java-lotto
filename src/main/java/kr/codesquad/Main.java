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
        person.MakeRandomLottoTickets(); // 구매 개수만큼의 랜덤한 로또 번호 생성

        for(int i = 0; i < person.getBuyNum(); i++)
        {
            System.out.println(person.getLottoTickets().get(i));
        }

        LottoMachine lottoMachine = new LottoMachine();

        System.out.println();
        System.out.println("당첨 번호를 입력해주세요"); sc.nextLine();
        String winNumberString = sc.nextLine();
        String splitedWinNum[] = winNumberString.split(", ");
        ArrayList<Integer> winNums = new ArrayList<Integer>();
        for(int i = 0; i < 6; i++)
        {
            winNums.add(Integer.parseInt(splitedWinNum[i]));
        }
        lottoMachine.setWinNums(winNums); // 로또 추첨기에 당첨 번호 넘기기

        System.out.println("보너스 볼을 입력해주세요");
        lottoMachine.setBonusBall(sc.nextInt()); // 로또 추첨기에 보너스 번호 넘기기

        ArrayList<Integer> result = lottoMachine.GetResult(person.getLottoTickets());
        person.PrintResult(result);
    }
}

enum LottoStatus{
    // 등수별 해당 등수가 되기 위한 정보 문자열과, 당첨 금액 정보를 담고 있는 열거체
    Fifth("3개 일치", 5000),
    Fourth("4개 일치", 50000),
    Third("5개 일치", 1500000),
    Second("5개 일치, 보너스 볼 일치", 30000000),
    First("6개 일치", 2000000000);

    LottoStatus(String val1, int val2)
    {
        setStatusString(val1);
        setWinningAmout(val2);
    }

    private String StatusString; // 상태메시지

    public String getStatusString() {
        return StatusString;
    }

    public void setStatusString(String statusString) {
        StatusString = statusString;
    }

    public int getWinningAmout() {
        return WinningAmout;
    }

    public void setWinningAmout(int winningAmout) {
        WinningAmout = winningAmout;
    }

    private int WinningAmout; // 당첨금액

}
package kr.codesquad.IO;
import kr.codesquad.Lotto.LottoStatus;
import kr.codesquad.User;

import java.util.ArrayList;
import java.util.Scanner;

public class Console {
    static Scanner scanner = new Scanner(System.in);

    public void printCashInstruction()
    {
        System.out.println("구입 금액을 입력하세요");
    }

    public String scanCashAmount()
    {
        return scanner.nextLine();
    }

    public void printManualTicketCountInstruction()
    {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
    }

    public String scanManualTicketCount()
    {
        return scanner.nextLine();
    }

    public void printManualTicketInstruction()
    {
        System.out.println("수동으로 구매할 번호를 입력해주세요.");
    }

    public String scanManualTicket()
    {
        return scanner.nextLine();
    }

    public void printManualAndAutoCount(int m, int a)
    {
        System.out.printf("수동으로 %d장, 자동으로 %d개를 구매했습니다.\n", m, a);
    }

    public void printAllTickets(User user)
    {
        printManualTickets(user);
        printAutoTickets(user);
    }
    private void printManualTickets(User user)
    {
        for(int i = 0; i < user.getManualCount(); i++)
        {
            System.out.println(user.getLottoTickets().get(i));
        }
    }
    private void printAutoTickets(User user)
    {
        int autoTicketStartIndex = user.getManualCount();
        for(int i = 0; i < user.getAutoCount(); i++)
        {
            System.out.println(user.getLottoTickets().get(autoTicketStartIndex + i));
        }
        System.out.println();
    }

    public void printLastWinnumInstruction()
    {
        System.out.println("지난 주 당첨 번호를 입력해주세요");
    }

    public String scanWinNums()
    {
        return scanner.nextLine();
    }

    public void printBonusBallInstruction()
    {
        System.out.println("보너스 볼을 입력해주세요");
    }

    public int scanBonusBall()
    {
        return scanner.nextInt();
    }

    public void printResult(ArrayList<Integer> Result, int buyNum)
    {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("-------------");

        for(LottoStatus stat : LottoStatus.values())
        {
            System.out.printf("%s, (%d)- %d개\n", stat.getStatusString(), stat.getWinningAmout(), Result.get(stat.ordinal()));
        }
//          System.out.printf("3개 일치 (5000원)- %d개\n", Result.get(0));
//          System.out.printf("4개 일치 (50000원)- %d개\n", Result.get(1));
//          System.out.printf("5개 일치 (1500000원)- %d개\n", Result.get(2));
//          System.out.printf("5개 일치, 보너스 볼 일치(30000000원)- %d개\n", Result.get(3));
//          System.out.printf("6개 일치 (2000000000원)- %d개\n", Result.get(4));

        float rate = (float)(
                LottoStatus.Fifth.getWinningAmout()*Result.get(0) +
                        LottoStatus.Fourth.getWinningAmout()*Result.get(1) +
                        LottoStatus.Third.getWinningAmout()*Result.get(2) +
                        LottoStatus.Second.getWinningAmout()*Result.get(3) +
                        LottoStatus.First.getWinningAmout()*Result.get(4) - buyNum*1000) /
                (float) (buyNum*1000)
                * 100;

        System.out.printf("총 수익률은 %.2f%% 입니다.\n", rate);
    }
}

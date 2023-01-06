package kr.codesquad.IO;
import kr.codesquad.Lotto.LottoStatus;
import kr.codesquad.User;
import kr.codesquad.customException.InvalidInputException;
import kr.codesquad.utility.Util;

import java.util.ArrayList;
import java.util.Scanner;

public class Console {
    static Scanner scanner = new Scanner(System.in);

    public enum ScanContext{ CASH, BONUS, MANUAL, MANUALBALL }

    private class consoleMemory
    {
        public String lastWinNum;
    }

    private consoleMemory LOG = new consoleMemory();

    public int scanCashAmount()
    {
        int cash = 0;
        try {
            cash = Util.toInt(scanner.nextLine(), ScanContext.CASH);
            return cash;
        } catch(InvalidInputException e) {
            System.out.println(e.getMessage());
        } catch(NumberFormatException e) {
            System.out.println("입력값이 숫자가 아니거나, 범위를 벗어납니다.");
            System.out.printf("범위 안에 들어가는 숫자를 입력하세요 : %d ~ %d\n", 1000, Integer.MAX_VALUE - (Integer.MAX_VALUE%1000));
        }
        printCashInstruction();
        cash = scanCashAmount();
        return cash;
    }


    public int scanManualTicketCount(int userCash)
    {
        int count;
        try{
            count = Util.toInt(scanner.nextLine(), ScanContext.MANUAL, userCash);
            return count;
        } catch(InvalidInputException e) {
            System.out.println(e.getMessage());
        } catch(NumberFormatException e) {
            System.out.println("입력값이 숫자가 아니거나, 구매가능개수를 초과합니다. 다시 입력하세요");
        }
        printManualTicketCountInstruction();
        count = scanManualTicketCount(userCash);
        return count;
    }


    public ArrayList<Integer> scanManualTicket()
    {
        ArrayList<Integer> ticket;
        try {
            ticket = Util.splitTo6Integers(scanner.nextLine());
            return ticket;
        } catch (InvalidInputException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("공 번호는 숫자만 가능합니다. 다시입력하세요");
        }
        printManualTicketInstruction();
        ticket = scanManualTicket();
        return ticket;
    }

    public int scanBonusBall()
    {
        int ret;
        try{
            ret = Util.toInt(scanner.nextLine(), ScanContext.BONUS);
            Util.checkAlreadySelected(LOG.lastWinNum, ret);
            Util.checkBallIsInRange(ret);
            return ret;
        }catch (InvalidInputException e) {
            System.out.println(e.getMessage());
        }catch(NumberFormatException e) {
            System.out.println("입력값이 숫자가 아닙니다. 올바른 값을 입력하세요");
        }
        printBonusBallInstruction();
        ret = scanBonusBall();
        return ret;
    }

    public ArrayList<Integer> scanWinNums()
    {
        String winNumStr = new String();
        ArrayList<Integer> winNumArray = new ArrayList<Integer>();
        try{
            winNumStr = scanner.nextLine();
            LOG.lastWinNum = winNumStr;
            winNumArray = Util.splitTo6Integers(winNumStr);
            return winNumArray;
        }catch (InvalidInputException e){
            System.out.println(e.getMessage());
        }catch(NumberFormatException e) {
            System.out.println("입력값이 숫자가 아닙니다. 올바른 값을 입력하세요");
        }
        printLastWinnumInstruction();
        winNumArray = scanWinNums();
        return winNumArray;
    }

    public void printCashInstruction()
    {
        System.out.println("구입 금액을 입력하세요");
    }


    public void printManualTicketCountInstruction()
    {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
    }

    public void printManualTicketInstruction()
    {
        System.out.println("수동으로 구매할 번호를 입력해주세요.");
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


    public void printBonusBallInstruction()
    {
        System.out.println("보너스 볼을 입력해주세요");
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

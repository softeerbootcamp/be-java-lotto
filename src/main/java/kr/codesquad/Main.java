package kr.codesquad;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);;
    private static User user = new User();
    private static LottoMachine lottoMachine = new LottoMachine();

    private static int scanCash()
    {
        return scanner.nextInt();
    }

    private static int scanManualTicketCount()
    {
        return scanner.nextInt();
    }

    private static ArrayList<ArrayList<Integer>> scanManualTickets()
    {
        ArrayList<ArrayList<Integer>> Tickets = new ArrayList<ArrayList<Integer>>();
        String newTicket;
        scanner.nextLine();
        for(int i = 0; i < user.getManualCount(); i++)
        {
            newTicket = scanner.nextLine();
            Tickets.add(splitTo6Integers(newTicket));
        }

        return Tickets;
    }

    private static void printAllTickets()
    {
        printManualTickets();
        printAutoTickets();
    }
    private static void printManualTickets()
    {
        for(int i = 0; i < user.getManualCount(); i++)
        {
            System.out.println(user.getLottoTickets().get(i));
        }
    }
    private static void printAutoTickets()
    {

        int autoTicketStartIndex = user.getManualCount();
        for(int i = 0; i < user.getAutoCount(); i++)
        {
            System.out.println(user.getLottoTickets().get(autoTicketStartIndex + i));
        }
        System.out.println();
    }

    private static ArrayList<Integer> scanWinNums()
    {
        scanner.nextLine();
        String winNumberString = scanner.nextLine();
        return splitTo6Integers(winNumberString);
    }

    private static int scanBonusBall()
    {
        return scanner.nextInt();
    }

    private static ArrayList<Integer> splitTo6Integers(String beforeSplited)
    {
        String splitedNums[] = beforeSplited.split(", ");
        ArrayList<Integer> afterSplited = new ArrayList<Integer>();
        for(int i = 0; i < 6; i++)
        {
            afterSplited.add(Integer.parseInt(splitedNums[i]));
        }
        return afterSplited;
    }
    public static void main(String[] args) {

        System.out.println("구입 금액을 입력하세요");
        int cash = scanCash();
        user.setCash(cash);

        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        int manualTicketCount = scanManualTicketCount();
        user.calculateBuyNum(manualTicketCount);

        System.out.println("수동으로 구매할 번호를 입력해주세요.");
        ArrayList<ArrayList<Integer>> manualTickets = scanManualTickets();
        user.setManualTickets(manualTickets);
        user.makeRandomLottoTickets(); // 구매 개수만큼의 랜덤한 로또 번호 생성

        System.out.printf("수동으로 %d장, 자동으로 %d개를 구매했습니다.\n", user.getManualCount(), user.getAutoCount());
        printAllTickets();

        System.out.println("당첨 번호를 입력해주세요");
        ArrayList<Integer> winNums = scanWinNums();

        lottoMachine.setWinNums(winNums); // 로또 추첨기에 당첨 번호 넘기기

        System.out.println("보너스 볼을 입력해주세요");
        int bonus = scanBonusBall();
        lottoMachine.setBonusBall(bonus); // 로또 추첨기에 보너스 번호 넘기기

        ArrayList<Integer> result = lottoMachine.getResult(user.getLottoTickets());
        user.calculateRateOfRetrun(result);
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
    private int WinningAmout; // 당첨금액

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


}
package kr.codesquad;

import kr.codesquad.IO.Console;
import kr.codesquad.Lotto.LottoMachine;

import java.util.ArrayList;
import java.util.Scanner;

public class App {

    static Scanner scanner = new Scanner(System.in);
    private Console console;
    private static User user = new User();
    private static LottoMachine lottoMachine = new LottoMachine();

    public App() {
        console = new Console();
    }

    public void play()
    {
        // 로또 구매
        purchaseLotto();
        // 구매 정보를 추첨기에 입력
        setUpLottoMachine();
        getResult();
    }

    private void purchaseLotto()
    {
        setCashInfo();

        setManualTicketInfo();

        getAutoTicketInfo();
    }

    private void setCashInfo()
    {
        console.printCashInstruction();
        int cash = Integer.parseInt(console.scanCashAmount());
        user.setCash(cash);
    }

    private void setManualTicketInfo()
    {
        console.printManualTicketCountInstruction();
        int manualTicketCount = Integer.parseInt(console.scanManualTicketCount());
        user.calculateBuyNum(manualTicketCount);

        console.printManualTicketInstruction();
        ArrayList<ArrayList<Integer>> manualTickets = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < user.getManualCount(); i++)
        {
            ArrayList<Integer> Ticket = splitTo6Integers(console.scanManualTicket());
            manualTickets.add(Ticket);
        }
        user.setManualTickets(manualTickets);
    }

    private void getAutoTicketInfo()
    {
        user.makeRandomLottoTickets(); // 구매 개수만큼의 랜덤한 로또 번호 생성
        console.printManualAndAutoCount(user.getManualCount(), user.getAutoCount());
        console.printAllTickets(user);
    }

    private void setUpLottoMachine()
    {
        console.printLastWinnumInstruction();
        ArrayList<Integer> winNums = splitTo6Integers(console.scanWinNums());
        lottoMachine.setWinNums(winNums); // 로또 추첨기에 당첨 번호 넘기기
        console.printBonusBallInstruction();
        int bonus = console.scanBonusBall();
        lottoMachine.setBonusBall(bonus); // 로또 추첨기에 보너스 번호 넘기기
    }

    private void getResult()
    {
        console.printResult(lottoMachine.getResult(user.getLottoTickets()), user.getBuyNum());
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
}

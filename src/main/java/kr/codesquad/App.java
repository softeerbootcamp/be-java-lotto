package kr.codesquad;

import kr.codesquad.IO.Console;
import kr.codesquad.Lotto.LottoMachine;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    static Scanner scanner = new Scanner(System.in);
    private Console console;
    private User user = new User();
    private LottoMachine lottoMachine = new LottoMachine();

    public App() {
        console = new Console();
    }

    public void play()
    {
        // 로또 구매
        purchaseLotto();
        // 구매 정보를 추첨기에 입력
        setUpLottoMachine();
        // 결과 출력
        getResult();
    }

    private void purchaseLotto()
    {
        // 구입 금액 입력
        setCashInfo();
        // 수동 로또 정보 입력
        setManualTicketInfo();
        // 자동 로또 추첨
        getAutoTicketInfo();
    }

    private void setCashInfo()
    {
        console.printCashInstruction();
        int cash = console.scanCashAmount();
        user.setCash(cash);
    }

    private void setManualTicketInfo()
    {
        console.printManualTicketCountInstruction();
        int manualTicketCount = Integer.parseInt(console.scanManualTicketCount());
        // 구매금액과 수동 개수를 바탕으로 전체 로또 개수와 자동/수동 개수 정보를 유저가 추론하게 함
        user.calculateBuyNum(manualTicketCount);

        console.printManualTicketInstruction();
        ArrayList<ArrayList<Integer>> manualTickets = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < user.getManualCount(); i++)
        {
            ArrayList<Integer> Ticket = splitTo6Integers(console.scanManualTicket());
            manualTickets.add(Ticket);
        }
        // 수동 로또 정보 저장
        user.setManualTickets(manualTickets);
    }

    private void getAutoTicketInfo()
    {
        ArrayList<ArrayList<Integer>> Tickets = lottoMachine.getRandomLottoTickets(user.getAutoCount());
        user.setAutoTickets(Tickets);

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

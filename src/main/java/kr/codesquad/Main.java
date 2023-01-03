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
        person.MakeRandomLottoTickets();
        System.out.printf("구매 개수는 %d개입니다.\n", person.getBuyNum());

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

        ArrayList<Integer> result = lottoMachine.GetResult(person.getLottoTickets());
        person.PrintResult(result);
    }
}
package kr.codesquad.InputService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputServiceImpl implements InputService{
    private long lottoCount;

    private ArrayList<Integer> winningNumberList;
    @Override
    public void inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        Scanner sc = new Scanner(System.in);
        lottoCount = Long.parseLong(sc.next())/1000;
    }

    @Override
    public void printLottoCount() {
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    @Override
    public void inputWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        Scanner sc = new Scanner(System.in);
        String wonNumbers = sc.nextLine().replaceAll(" ", "");
        winningNumberList = (ArrayList<Integer>) Arrays.stream(wonNumbers.split(",")).map(Integer::valueOf).collect(Collectors.toList());
    }

    public ArrayList<Integer> getWinningNumberList() {
        return winningNumberList;
    }

    public long getLottoCount() {
        return lottoCount;
    }
}

package kr.codesquad.LottoService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class LottoServiceImpl implements LottoService{
    private ArrayList<ArrayList<Integer>> lottos;
    private long threeWinningNumbers;
    private long fourWinningNumbers;
    private long fiveWinningNumbers;
    private long sixWinningNumbers;

    public ArrayList<ArrayList<Integer>> getLottos() {
        return lottos;
    }

    @Override
    public void setLottoNumbers(long lottoCount) {
        List<Integer> num = new ArrayList<>();
        for (int i = 1 ; i <= 45 ; i++){
            num.add(i);
        }
        lottos = new ArrayList<>();
        for (int i = 0 ; i < lottoCount ; i++){
            Collections.shuffle(num);
            lottos.add(new ArrayList<>(num.subList(0,6)));
        }
    }

    @Override
    public void printLottos() {
        for (ArrayList<Integer> lotto : lottos) {
            System.out.println(lotto);
        }
    }

    @Override
    public void printWonLottos() {
        System.out.println("당첨 통계");
        System.out.println("--------");
        System.out.println("3개 일치 (5000원)- " + threeWinningNumbers + "개");
        System.out.println("4개 일치 (50000원)- "  + fourWinningNumbers + "개");
        System.out.println("5개 일치 (1500000원)- " + fiveWinningNumbers + "개");
        System.out.println("6개 일치 (2000000000원)- " + sixWinningNumbers + "개");
    }
}

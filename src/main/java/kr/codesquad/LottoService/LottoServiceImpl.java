package kr.codesquad.LottoService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoServiceImpl implements LottoService{
    private List<List<Integer>> lottos;
    private long[] winningNumbersCount = new long[7];
    private static final long[] winningMoney = {0, 0, 0, 5000, 50000, 1500000, 2000000000};

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
        for (List<Integer> lotto : lottos) {
            System.out.println(lotto);
        }
    }

    @Override
    public void printWinningLottos() {
        System.out.println("당첨 통계");
        System.out.println("---------");
        for (int i = 3 ; i <= 6 ; i++){
            String line = String.format("%d개 일치 (%d원)- %d개", i, winningMoney[i], winningNumbersCount[i]);
            System.out.println(line);
        }
    }


    public int countMatchNumber(ArrayList<Integer> lotto, ArrayList<Integer> wonNumberList) {
        return (int)lotto.stream().filter(wonNumberList::contains).count();
    }

    public void setWinningNumbers(List<Integer> wonNumberList){
        for (List<Integer> lotto : lottos) {
            winningNumbersCount[countMatchNumber((ArrayList<Integer>) lotto, (ArrayList<Integer>) wonNumberList)]++;
        }
    }

    public void calculateEarningRate(long lottoCount){
        long earningSum = 0;
        for (int i = 0 ; i < 7 ; i++){
            earningSum += winningMoney[i]/1000 * winningNumbersCount[i];
        }
        float earingRate = 0;
        if (lottoCount != 0) {
            earingRate = (earningSum - lottoCount)/(float)lottoCount * 100;
        }
        System.out.printf("총 수익률은 %.2f%%입니다.", Math.ceil(earingRate * 100)/100);
    }
}

package kr.codesquad;

import kr.codesquad.domain.Row;
import kr.codesquad.domain.Statistic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AutoLottoGenerator implements LottoGenerator {

    @Override
    public List<Row> generateRows(int inputMoney) {
        List<Row> rows = new ArrayList<>();
        int num = Statistic.getRowCountICanBuy(inputMoney);
        for (int i = 0; i < num; i++) {
            rows.add(generateAutoNums());
        }
        return rows;
    }

    public Row generateAutoNums() {
        List<Integer> randomNumberList = createSeed();
        Collections.shuffle(randomNumberList);
        List<Integer> generatedNums = randomNumberList.subList(0, 6);
        Collections.sort(generatedNums);
        return Row.createRow(generatedNums);
    }

    private static List<Integer> createSeed() {
        return IntStream.range(1, 45).boxed().collect(Collectors.toList());
    }
}

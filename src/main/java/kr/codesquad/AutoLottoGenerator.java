package kr.codesquad;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AutoLottoGenerator implements LottoGenerator {

    @Override
    public List<Row> generateRows(int inputMoney) {
        List<Row> rows = new ArrayList<>();
        int num = inputMoney / LottoController.SINGLE_PRICE;
        for (int i = 0; i < num; i++) {
            rows.add(generateAutoNums());
        }
        return rows;
    }

    public Row generateAutoNums() {
        List<Integer> randomNumberList = createSeed();
        Collections.shuffle(randomNumberList);
        Row row = new Row();
        List<Integer> tempt = randomNumberList.subList(0, 6);
        Collections.sort(tempt);
        row.addValues(tempt);
        return row;
    }

    private static List<Integer> createSeed() {
        return IntStream.range(1, 45).boxed().collect(Collectors.toList());
    }
}

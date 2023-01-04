package kr.codesquad.Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AutoLottoGenerator implements LottosGenerator{
    public List<Lotto> generate(Money money) {
        List<Lotto> lottoList = new ArrayList<>();
        for(int i = 0;i < money.countLottos();i++){
            lottoList.add(generateAuto());
        }
        return lottoList;
    }

    public static Lotto generateAuto(){
        List<Integer> lotto = createSeed();
        Collections.shuffle(lotto);
        lotto = lotto.subList(0, 6);
        Collections.sort(lotto);
        return Lotto.of(lotto);
    }

    public static List<Integer> createSeed(){
        return IntStream.range(1, 46).boxed().collect(Collectors.toList());
    }

}

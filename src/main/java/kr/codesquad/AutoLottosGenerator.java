package kr.codesquad;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AutoLottosGenerator implements LottosGenerator{
    public static final int LOTTO_NUM_MAX = 45;
    public static final int LOTTO_NUM_CNT = 6;

    @Override
    public List<Lotto> generate(Money money) {
        List<Lotto> lottos = new ArrayList<>();
        for(int i=0; i< money.countLotto(); i++){
            lottos.add(generateLotto());
        }
        return lottos;
    }
    public Lotto generateLotto(){
        List<Integer> temp = IntStream.range(1, LOTTO_NUM_MAX+1).boxed().collect(Collectors.toList());
        Collections.shuffle(temp);
        List<Integer> nums = new ArrayList<>(temp.subList(0,LOTTO_NUM_CNT));
        Collections.sort(nums);
        return new Lotto(nums);
    }

}

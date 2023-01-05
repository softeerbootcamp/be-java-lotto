package kr.codesquad.sequence;

import kr.codesquad.Lotto;
import kr.codesquad.Money;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ShuffleSequenceGenerator implements LottosGenerator {
    private static List<Integer> range = IntStream.range(1,45).boxed().collect(Collectors.toList());
    @Override
    public List<Lotto> generate(final int ticketsToGenerate) {
        List<Lotto> lottos = new ArrayList<>();
        for(int i=0;i<ticketsToGenerate;++i) {
            Collections.shuffle(range);
            lottos.add(new Lotto(new HashSet<>(range.stream().limit(LOTTO_LENGTH).collect(Collectors.toList()))));
        }

        return lottos;
    }


}

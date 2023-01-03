package kr.codesquad.sequence;

import kr.codesquad.Lotto;
import kr.codesquad.Money;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ShuffleSequenceGenerator implements LottosGenerator {
    private static List<Integer> range = IntStream.range(1,25).boxed().limit(6).collect(Collectors.toList());
    @Override
    public List<Lotto> generate(Money money) {
        List<Lotto> lottos = new ArrayList<>();
        for(int i=0;i<money.numOfTickets;++i) {
            Collections.shuffle(range);
            lottos.add(new Lotto(new HashSet<>(range)));
        }

        return lottos;
    }


}

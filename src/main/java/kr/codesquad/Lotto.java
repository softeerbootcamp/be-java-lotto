package kr.codesquad;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class Lotto {
    private final List<List<Integer>> lottoList;
    private final Lotto nextLotto;

    public Lotto(List<List<Integer>> lottoList, Lotto nextLotto) {
        this.lottoList = lottoList;
        this.nextLotto = nextLotto;
    }

    public List<List<Integer>> getLottoList() {
        return nextLotto == null ?
                lottoList :
                Stream.of(lottoList, nextLotto.getLottoList())
                        .flatMap(Collection::stream)
                        .collect(Collectors.toList());
    }
}
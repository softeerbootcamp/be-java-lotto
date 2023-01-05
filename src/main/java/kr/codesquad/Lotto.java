package kr.codesquad;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class Lotto {
    private final List<List<Integer>> lottoList;
    private final Lotto nextLotto;

    public List<List<Integer>> getLottoList() {
        return this.lottoList;
    }
}
package kr.codesquad.domain;

import java.util.*;
public class Result {

    private final Map<Rank, Integer> result = new HashMap<>();

    public Result() {
        Arrays.stream(Rank.values()).forEach(rank -> result.put(rank, 0));
    }



}

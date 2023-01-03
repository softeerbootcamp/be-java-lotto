package kr.codesquad.model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public enum Result {
    NOT_MATCH(0, 0),
    MATCH_THREE(3, 5000),
    MATCH_FOUR(4, 50000),
    MATCH_FIVE(5, 1500000),
    MATCH_SIX(6, 2000000000),
    ;

    private final int matchCount;
    private final int reward;

    Result(int matchCount, int reward) {
        this.matchCount = matchCount;
        this.reward = reward;
    }

    public static Result getResult(int matchCount) {
        return Arrays.stream(values())
                .filter(value -> value.isMatch(matchCount))
                .findAny()
                .orElse(NOT_MATCH);
    }

    private boolean isMatch(int matchCount) {
        return this.matchCount == matchCount;
    }





    public static List<Result> notIncludeNotMatch() {
        return Arrays.stream(values())
                .filter(value -> !value.isMatch(NOT_MATCH.matchCount))
                .collect(Collectors.toList());
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getReward() {
        return reward;
    }
}

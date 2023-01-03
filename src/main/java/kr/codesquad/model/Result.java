package kr.codesquad.model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public enum Result {
    NOT_MATCH(0, 0, false),
    MATCH_THREE(3, 5000, false),
    MATCH_FOUR(4, 50000,false),
    MATCH_FIVE(5, 1500000, false),
    MATCH_FIVE_BONUS(5, 30000000,true),
    MATCH_SIX(6, 2000000000,false),
    ;

    private final int matchCount;
    private final int reward;
    private final boolean bonus;

    Result(int matchCount, int reward,boolean bonus) {
        this.matchCount = matchCount;
        this.reward = reward;
        this.bonus = bonus;
    }

    public static Result getResult(int matchCount, boolean bonus) {
        return Arrays.stream(values())
                .filter(value -> value.isMatch(matchCount, bonus))
                .findAny()
                .orElse(NOT_MATCH);
    }


    private boolean isMatch(int matchCount, boolean bonus) {
        return this.matchCount == matchCount && this.bonus==bonus;
    }





    public static List<Result> notIncludeNotMatch() {
        return Arrays.stream(values())
                .filter(value -> !value.isMatch(NOT_MATCH.matchCount, NOT_MATCH.bonus))
                .collect(Collectors.toList());
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getReward() {
        return reward;
    }

    public boolean isBonus() {
        return bonus;
    }
}

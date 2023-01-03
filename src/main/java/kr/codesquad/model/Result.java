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

    public static void computeResult(User user,WinningLotto winningLotto) {
        HashSet<Integer> winLottoSet = listToHashSet(winningLotto.numbers);
        for (Lotto usersLotto : user.getLottos()) {
            perComputeResult(user, winLottoSet, usersLotto);
        }
    }

    private static void perComputeResult(User user, HashSet<Integer> winLottoSet, Lotto usersLotto) {
        Integer matchCount = 0;
        for (Integer lottoNumber : usersLotto.getNumbers()) {
            matchCount+=matchCountPlus(winLottoSet, lottoNumber);
        }
        user.updateResult(matchCount);
    }

    private static int matchCountPlus(HashSet<Integer> winLottoSet, Integer lottoNumber) {
        if (winLottoSet.contains(lottoNumber)) {
            return 1;
        } else return 0;
    }

    private static HashSet<Integer> listToHashSet(List<Integer> list) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (Integer integer : list) {
            hashSet.add(integer);
        }
        return hashSet;
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

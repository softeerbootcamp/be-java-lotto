package kr.codesquad.model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class WinningStatic {

    private double profit;

    private HashMap<Result, Integer> resultMatch = new HashMap<>();

    public WinningStatic() {
        this.profit = 0;
        initialResult();
    }

    public void updateProfit(Double profit) {
        this.profit = profit;
    }

    public void updateResult(int matchCount) {
        Result result = Result.getResult(matchCount);
        Integer winCount = resultMatch.get(result);
        resultMatch.put(result, winCount + 1);
    }

    private void initialResult() {
        for (Result result : Result.values()) {
            resultMatch.put(result, 0);
        }
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
        user.getWinningStatic().updateResult(matchCount);
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

    public static double computeProfit(User user) {
        int totalReward = 0;
        for (Map.Entry<Result, Integer> perResult : user.getWinningStatic().getResultMatch().entrySet()) {
            Integer winCount = perResult.getValue();
            int reward = perResult.getKey().getReward();
            totalReward += (reward * winCount);
        }

        return (totalReward-user.getPurchaseAmount()) / (double) user.getPurchaseAmount() * 100;
    }

    public double getProfit() {
        return profit;
    }

    public HashMap<Result, Integer> getResultMatch() {
        return resultMatch;
    }
}

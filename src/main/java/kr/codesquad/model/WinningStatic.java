package kr.codesquad.model;

import java.util.HashSet;
import java.util.List;

public class WinningStatic {

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
}

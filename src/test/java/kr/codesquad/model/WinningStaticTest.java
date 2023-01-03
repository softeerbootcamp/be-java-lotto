package kr.codesquad.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class WinningStaticTest {

    @Test
    @DisplayName("당첨번호 결과 로직 테스트")
    void computeResult() {
        //given
        User user = new User(10000, 10);

        //첫번째 자동으로 생성된 로또번호와 같게 당첨번호를 설정
        List<Integer> winLotto = user.getLottos().get(0).getNumbers();
        int bonusBall = 12;
        WinningLotto winningLotto = new WinningLotto(winLotto,bonusBall);
        //when
        WinningStatic.computeResult(user, winningLotto);
        //then
        Integer matchCount = user.getWinningStatic().getResultMatch().get(Result.MATCH_SIX);
        assertThat(matchCount).isEqualTo(1);
    }

    @Test
    @DisplayName("resultMatch 초기 정상생성 테스트")
    public void checkResultMatchMap() {
        //given
        int purchaseMoney = 10000;
        int purchaseTickets = 10;
        //when
        User user = new User(purchaseMoney, purchaseTickets);
        HashMap<Result, Integer> resultMatch = user.getWinningStatic().getResultMatch();
        //then
        for (Result result : Result.values()) {
            assertTrue(resultMatch.containsKey(result));
        }
    }
}
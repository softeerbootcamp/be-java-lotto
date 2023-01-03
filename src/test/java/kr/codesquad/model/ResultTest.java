package kr.codesquad.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class ResultTest {

    @Test
    @DisplayName("matchCount를 이용하여 Result객체 찾기 테스트")
    void getResult() {
        //given
        Result fourMatchResult = Result.MATCH_FOUR;
        int matchCount=4;
        //when
        Result result = Result.getResult(matchCount);
        //then
        assertThat(result).isEqualTo(fourMatchResult);
    }

    @Test
    @DisplayName("당첨번호 결과 로직 테스트")
    void computeResult() {
        //given
        User user = new User(10000, 10);

            //첫번째 자동으로 생성된 로또번호와 같게 당첨번호를 설정
        List<Integer> winLotto = user.getLottos().get(0).getNumbers();
        WinningLotto winningLotto = new WinningLotto(winLotto);
        //when
        Result.computeResult(user, winningLotto);
        //then
        Integer matchCount = user.getResultMatch().get(Result.MATCH_SIX);
        assertThat(matchCount).isEqualTo(1);
    }
}
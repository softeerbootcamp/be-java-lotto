package kr.codesquad.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
    @DisplayName("0개일치가 포함되지 않는 Result전체 가져오기")
    void notIncludeZero() {
        List<Result> results = Result.notIncludeNotMatch();
        assertFalse(results.contains(Result.NOT_MATCH));
    }
}
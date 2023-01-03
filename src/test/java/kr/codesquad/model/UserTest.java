package kr.codesquad.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    @Test
    @DisplayName("사용자가 구매한 로또 총 개수 성공 테스트")
    public void checkMakeUser() {
        //given
        int purchaseMoney = 10000;
        int purchaseTickets = 10;
        //when
        User user = new User(purchaseMoney, purchaseTickets);
        //then
        assertThat(user.getLottos().size()).isEqualTo(purchaseTickets);
    }


}
package kr.codesquad.service.Inteface;

import kr.codesquad.domain.Person;

import java.util.List;

public interface MakeLottoInterface {
    void issuedLotto(Person person);

    List<Integer> makeLottoNumber();
}

package kr.codesquad.generator.condition;

import java.util.List;
import java.util.function.Predicate;

public interface ConditionGenerator<T> {
    List<Predicate<T>> getMoneyCondition();

    List<Predicate<T>> getManualLottoCountCondition();

    List<Predicate<T>> getLottoNumberCondition();

    List<Predicate<T>> getBonusNumberCondition();
}
/*
시스템 오류 -> input layer
비즈니스 오류 -> service layer

금액 입력
    숫자가 아닌 값을 입력 -> 정규식, 시스템 O  (isNumeric)
수동 개수 입력
    숫자가 아닌 값을 입력 -> 정규식, 시스템 O (isNumeric)
    금액보다 큰 경우 (1000원 < 수동 2장) - 비즈니스
수동 로또 번호 입력
    숫자가 아닌 값을 입력, 잘못된 형식 -> 정규식, 시스템 O (isNumeric)
    잘못된 형식 -> 정규식, 시스템 O
    범위를 넘어간 값 입력 -> 정규식 - 비즈니스
    중복된 숫자 - 비즈니스
로또 번호 출력
당첨 로또 번호 입력
    숫자가 아닌 값을 입력, 잘못된 형식 -> 정규식, 시스템 O
    범위를 넘어간 값 입력 -> 정규식, 비즈니스
보너스 볼 입력
    숫자가 아닌 값을 입력 -> 정규식, 시스템
    중복된 숫자, 비즈니스
결과 출력
 */
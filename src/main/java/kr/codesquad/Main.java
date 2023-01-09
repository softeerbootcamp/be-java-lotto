package kr.codesquad;

import kr.codesquad.domain.Lotto;
import kr.codesquad.domain.Person;
import kr.codesquad.service.CountNumber;
import kr.codesquad.service.Input.InputService;

public class Main {

    static Person person = new Person();
    static Lotto lotto = new Lotto();
    static CountNumber countNumber = new CountNumber();
    static InputService inputService = new InputService();

    public static void main(String[] args) {
        inputService.moneyInput(person);
        inputService.startLottoInput(lotto);
        person = countNumber.collectNumberCount(person, lotto);
        person.print();
    }
}
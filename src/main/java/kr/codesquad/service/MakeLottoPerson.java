package kr.codesquad.service;

import kr.codesquad.domain.Person;
import kr.codesquad.exception.CustomValideException;
import kr.codesquad.service.Input.ScannerInput;
import kr.codesquad.service.Inteface.MakeLottoInterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MakeLottoPerson implements MakeLottoInterface {

    ScannerInput scannerInput = new ScannerInput();
    CustomValideException customException = new CustomValideException();

    @Override
    public void issuedLotto(Person person) {
        for (int i = 0; i < person.getHaveHandLotto(); i++) {
            person.addLotto(makeLottoNumber()); // 사용자 로또 생성
        }
    }

    @Override
    public List<Integer> makeLottoNumber() {
        String numberLine = scannerInput.inputLine();
        String[] split = numberLine.split(",");
        customException.inputHanLottoCheck(split.length);
        customException.numberCheck(split);
        List<String> inputNumber = Arrays.asList(split);
        List<Integer> changeInteger = new ArrayList<>();
        for (String i : inputNumber) changeInteger.add(Integer.parseInt(i.trim()));
        return changeInteger;
    }
}

package kr.codesquad;

import kr.codesquad.exception.CustomException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Util {
    /*
     * Util class의 인스턴스화를 막기 위해 생성자를 private으로 설정
     * Util class 내부에서도 생성자를 사용하지 못하도록 예외 처리
     */
    private Util() throws InstantiationException {
        throw new InstantiationException();
    }

    // 수동으로 로또를 구매하거나 당첨 번호를 입력하는 경우, String으로 받아 와서 parsing하는 기능의 함수
    public static List<Integer> parseInputNumString() {
        Scanner sc = new Scanner(System.in);
        String[] parseNumList = validateInputString(sc.nextLine());

        int numCount = parseNumList.length;
        if(numCount != 6) throw new CustomException("6개의 숫자를 올바른 형식에 맞게 입력해야 합니다.(입력 형식: 1, 2, 3, 4, 5, 6)");

        List<Integer> numList = new ArrayList<>(numCount);
        for (String parseNum : parseNumList) numList.add(Integer.parseInt(parseNum));

        return numList;
    }

    private static String[] validateInputString(String string) {
        String[] parseNumList;

        try {
            parseNumList = string.split(", ");
        } catch(Exception e) {
            throw new CustomException("잘못된 입력 형식입니다.");
        }

        return parseNumList;
    }
}

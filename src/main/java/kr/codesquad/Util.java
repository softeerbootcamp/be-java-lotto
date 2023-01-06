package kr.codesquad;

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

    public static List<Integer> parseInputNumString() {
        Scanner sc = new Scanner(System.in);
        String[] parseNumList = sc.nextLine().split(", ");

        int numCount = parseNumList.length;
        List<Integer> numList = new ArrayList<>(numCount);
        for (String parseNum : parseNumList) numList.add(Integer.parseInt(parseNum));

        return numList;
    }
}

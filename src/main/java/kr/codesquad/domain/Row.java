package kr.codesquad.domain;

import java.util.*;

public class Row {

    private final List<Integer> values = new ArrayList<>();
    private int match;
    private boolean isBonus;
    public static final int COLUMN = 6;


    public static Row createRow(List<Integer> numbers) {
        Row row = new Row();
        row.addValues(numbers);
        return row;
    }

    /**
     * 각 list 별 정답과 일치하는 갯수 반환
     */
    public void compare(WinningNumbers winningNumbers) {
        List<Integer> answers = winningNumbers.getRow().values;
        for (int answer : answers) {
            compareNumber(answer);
        }
        compareBonusNumber(winningNumbers.getBonusNum());
    }

    public void compareNumber(int answer) {
        if (this.values.contains(answer)) {
            this.match++;
        }
    }

    public void compareBonusNumber(int bonusNumber) {
        this.isBonus = this.values.contains(bonusNumber);
    }

    public void addValues(List<Integer> num) {
        values.addAll(num);
    }

    public int getMatch() {
        return match;
    }

    public List<Integer> getValues() {
        return values;
    }

    public boolean isBonus() {
        return isBonus;
    }

    public static Row convertStringToRow(String rowByString) {
        StringTokenizer st = new StringTokenizer(rowByString);
        List<Integer> numbers = new ArrayList<>();
        while (st.hasMoreTokens()) {
            numbers.add(Integer.valueOf(st.nextToken()));
        }
        return createRow(numbers);
    }
}

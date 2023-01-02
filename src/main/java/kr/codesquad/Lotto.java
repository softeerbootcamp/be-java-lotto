package main.java.kr.codesquad;

import java.util.*;

public class Lotto implements LottoInterface{
    private ArrayList<Integer> numberList;
    private ArrayList<Integer> lottoList;
    private ArrayList<Integer> jackpotNumbers;
    private ArrayList<Integer> jackpotCount;
    public Lotto() {
        numberList = new ArrayList<>();
        lottoList = new ArrayList<>();
        jackpotNumbers = new ArrayList<>();
        jackpotCount = new ArrayList<>();
        for(int i=1;i<=45;i++)
        {
            numberList.add(i);
        }
    }

    @Override
    public void makeLottoList(int count)
    {
        Collections.shuffle(numberList);

        for(int i=0;i<count;i++)
        {
            int start = new Random().nextInt(39);
            lottoList.addAll(numberList.subList(start, start+6));
        }
    }

    @Override
    public void printLottoList(int count) {
        int idx = 0;
        while(idx < count)
        {
            int start = idx * 6;
            System.out.println(lottoList.subList(start, start+6));
            idx++;
        }
    }

    @Override
    public void getJackPotNumbers(String st) {
        StringTokenizer stringTokenizer = new StringTokenizer(st," ");
        while(stringTokenizer.hasMoreTokens())
        {
            jackpotNumbers.add(stringTokenizer.nextToken().charAt(0)-'0');
        }
    }

    public void checkJackPots()
    {
        for(int i=0;i<lottoList.size()/6;i++)
        {
            getJackPots(lottoList.subList(i,i+6));
        }
    }

    @Override
    public void getJackPots(List<Integer> list) {
        jackpotNumbers.forEach((elem)->{});
    }
}

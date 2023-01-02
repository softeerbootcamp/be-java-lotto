package main.java.kr.codesquad;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Lotto implements LottoInterface {
    private ArrayList<Integer> numberList;
    private ArrayList<Integer> lottoList;
    private ArrayList<Integer> jackpotNumbers;
    int[] counts = new int[4];

    public Lotto() {
        numberList = new ArrayList<>();
        lottoList = new ArrayList<>();
        jackpotNumbers = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            numberList.add(i);
        }
        for(int i=0;i<4;i++)
        {
            counts[i] = 0;
        }
    }

    int checkDuplicate(int num, int idx)
    {
        if(lottoList.subList(6 * (idx/6), lottoList.size()).contains(num))
        {
            return 0;
        }
        lottoList.add(num);
        return 1;
    }

    @Override
    public void makeLottoList(int count)
    {
        Collections.shuffle(numberList);
        Random random = new Random();

        int idx = 0;
        while(idx < count*6)
        {
            int num = random.nextInt(44) + 1;
            idx += checkDuplicate(num ,idx);
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
        StringTokenizer stringTokenizer = new StringTokenizer(st,", ");
        while(stringTokenizer.hasMoreTokens())
        {
            jackpotNumbers.add(Integer.parseInt(stringTokenizer.nextToken()));
        }
    }

    @Override
    public void checkJackPots()
    {
        for(int i=0;i<lottoList.size();i+=6)
        {
            getJackPots(lottoList.subList(i,i+6));
        }
    }
    public int doesContain(boolean flag)
    {
        if(flag)
        {
            return 1;
        }
        return 0;
    }
    public void getJackPots(List<Integer> list) {
        AtomicInteger cnt = new AtomicInteger();
        jackpotNumbers.forEach((elem)->{cnt.addAndGet(doesContain(list.contains(elem)));});

        if(Integer.parseInt(cnt.toString()) >= 3)
        {
            counts[Integer.parseInt(cnt.toString())-3]++;
        }
    }
}

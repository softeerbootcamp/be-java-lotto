package kr.codesquad;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    static public ArrayList<ArrayList<Integer>> Lottos = new ArrayList<ArrayList<Integer>>();
    static public ArrayList<Integer> WinNumbers  = new ArrayList<Integer>();
    static Integer buyNum;

    static public void getRandom()
    {
        ArrayList<Integer> Numbers = new ArrayList<Integer>();
        for(Integer i = 1; i <= 45; i++) Numbers.add(i);
        for(Integer i = 0; i < buyNum; i++)
        {
            Collections.shuffle(Numbers);
            for(int j = 0; j < 6; j++) {
                Lottos.get(i).add(Numbers.get(j));
            }
            Collections.sort(Lottos.get(i));
        }
    }

    static public void printRandoms()
    {
        for(int i = 0; i < buyNum; i++)
        {
            System.out.println(Lottos.get(i));
        }
    }

    static public void printResult()
    {
        ArrayList<Integer> Result = GetResult();
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("-------------");
        System.out.printf("3개 일치 (5000원)- %d개\n", Result.get(0));
        System.out.printf("4개 일치 (50000원)- %d개\n", Result.get(1));
        System.out.printf("5개 일치 (1500000원)- %d개\n", Result.get(2));
        System.out.printf("6개 일치 (2000000000원)- %d개\n", Result.get(3));

        float rate = (float)(5000*Result.get(0) + 50000*Result.get(1) + 1500000*Result.get(2) + 2000000000*Result.get(3) - buyNum*1000) / (float) (buyNum*1000) * 100;

        System.out.printf("총 수익률은 %f퍼센트 입니다.\n", rate);
    }

    static ArrayList<Integer> GetResult()
    {
        ArrayList<Integer> ret = new ArrayList<Integer>();
        ret.add(0);
        ret.add(0);
        ret.add(0);
        ret.add(0);
        for(int i = 0; i < buyNum; i++)
        {
            int count = 0;
            for(int j = 0; j < 6; j++)
            {
                if(Lottos.get(i).contains(WinNumbers.get(j))) count++;
            }
            if(count == 3) ret.set(0, ret.get(0)+1);
            if(count == 4) ret.set(1, ret.get(1)+1);
            if(count == 5) ret.set(2, ret.get(2)+1);
            if(count == 6) ret.set(3, ret.get(3)+1);
        }
        return ret;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("구입 금액을 입력하세요");
        buyNum = sc.nextInt() / 1000;
        for(int i = 0; i < buyNum; i++)
        {
            Lottos.add(new ArrayList<Integer>());
        }
        getRandom();
        printRandoms();

        System.out.println();
        System.out.println("당첨 번호를 입력해주세요");

        for(int i = 0; i < 6; i++)
        {
            WinNumbers.add(sc.nextInt());
        }

        printResult();
    }
}
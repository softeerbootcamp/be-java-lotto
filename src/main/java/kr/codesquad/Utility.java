package kr.codesquad;

import java.lang.reflect.Array;
import java.util.*;

public class Utility {

    public static ArrayList<Integer> generateRandomSixNumbers(){
        ArrayList<Integer> oneTo45 = new ArrayList<>();
        ArrayList<Integer> lotteryNumbers = new ArrayList<Integer>();
        for(int i = 1; i<=45; i++){
            oneTo45.add(i);
        }

        Collections.shuffle(oneTo45);

        for(int i =0; i<6; i++){
            lotteryNumbers.add(oneTo45.get(i));
        }
        Collections.sort(lotteryNumbers);
        return lotteryNumbers;
    }

    public static int generateBonusNumber(ArrayList<Integer> random6Number){
        Random random = new Random();
        int temp = random.nextInt()%45 + 1;
        while(random6Number.contains(temp)){
            temp = random.nextInt()%45 + 1;
        }
        return temp;
    }
}

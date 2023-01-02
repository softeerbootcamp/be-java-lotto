package kr.codesquad;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        int n_lotto = UserInputHandler.getMoney() / 1000;
        ArrayList<Lotto> lottos = generateLottos(n_lotto);
        ArrayList<Integer> winningNumbers = UserInputHandler.getWinningNumbers();
        LottoStat lottoStat = new LottoStat(lottos, winningNumbers);
        lottoStat.printResult();
    }

    public static ArrayList<Lotto> generateLottos(int n_lotto){
        ArrayList<Lotto> lottos = new ArrayList<>();
        for(int i =0; i<n_lotto; i++){
            lottos.add(new Lotto());
        }
        return lottos;
    }

}
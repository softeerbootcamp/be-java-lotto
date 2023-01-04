package kr.codesquad;

import java.util.*;


public class User extends BaseLotto{

    private ArrayList<Integer> inputs; //저번 주 당첨 번호
    private int bonusBall; //보너스 볼

    public User() {
        this.inputs = new ArrayList<>();
        this.lottoList=new ArrayList<>();
    }

    @Override
    public ArrayList<ArrayList<Integer>> getLottoList() {
        System.out.println("수동으로 구매할 번호를 입력해주세요.");
        for(int i=0;i<this.lottoCnt;i++){
            ArrayList<Integer> manualLotto = getManualLotto();
            this.lottoList.add(manualLotto);
        }
        return this.lottoList;
    }

    @Override
    public Integer getLottoCnt(int amountOfMoney, int manualLottoCount) {
        //to do : 총 가능한 로또 개수를 넘어서서 구입되지 않도록 막아야 함
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요. ");
        Scanner sc = new Scanner(System.in);
        this.lottoCnt = sc.nextInt();
        return this.lottoCnt;
    }

    public ArrayList<Integer> getManualLotto(){
        Scanner sc = new Scanner(System.in);
        //to-do : input 넘버가 중복이 되면 안 됨
        String inputNumbers = sc.nextLine();
        ArrayList<Integer> manualLotto=new ArrayList<>();
        for(String input : inputNumbers.split(", ")){
            manualLotto.add(Integer.valueOf(input));
        }
        return manualLotto;
    }


    public ArrayList<Integer> getLottoInput(){
        System.out.println("당첨 번호를 입력해주세요.");
        Scanner sc = new Scanner(System.in);
        String inputNumbers = sc.nextLine();
        for(String input : inputNumbers.split(", ")){
            inputs.add(Integer.valueOf(input));
        }
        return inputs;
    }

    public Integer getBonusLottoInput() {
        System.out.println("보너스 볼을 입력해주세요. ");
        Scanner sc = new Scanner(System.in);
        this.bonusBall = sc.nextInt();
        return bonusBall;
    }


}

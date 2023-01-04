package kr.codesquad;

import kr.codesquad.exception.CustomException;
import kr.codesquad.exception.ErrorCode;

import java.util.*;


public class User extends BaseLotto{

    private int bonusBall; //보너스 볼

    public User() {
        //this.inputs = new ArrayList<>();
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
        do {
            System.out.print("수동으로 구매할 로또 수를 입력해 주세요. ");
            try {
                Scanner sc = new Scanner(System.in);
                this.lottoCnt = sc.nextInt();
                if(this.lottoCnt*1000>amountOfMoney) throw new CustomException(ErrorCode.MONEY_NOT_ENOUGH);
            }catch(InputMismatchException e){
                System.out.println("유효하지 않은 값입니다. 다시 값을 입력해주세요.");
                continue; //다시 반복문의 처음으로 돌아가 입력값을 다시 입력받음
            }catch(Exception e){
                System.out.println("입력에 에러가 발생했습니다. 다시 값을 입력해주세요");
                continue;
            }
            break; // do-while을 통한 입력 벗어남
        } while (true);

        return this.lottoCnt;
    }

    public ArrayList<Integer> getManualLotto(){
        Scanner sc = new Scanner(System.in);
        //to-do : input 넘버가 중복이 되면 안 됨
        String inputNumbers = sc.nextLine();
        ArrayList<Integer> manualLotto=new ArrayList<>();
        if(inputNumbers.split(", ").length != 6) throw new CustomException(ErrorCode.ILLEGAL_LOTTO_NUM_COUNT);
        try{
            for(String input : inputNumbers.split(", ")){
                manualLotto.add(Integer.valueOf(input));
            }
        }catch(Exception e){
            System.out.println("입력 양식을 다시 확인해주세요");
        }

        return manualLotto;
    }

    public Integer getBonusLottoInput() {
        System.out.println("보너스 볼을 입력해주세요. ");
        try{
            Scanner sc = new Scanner(System.in);
            this.bonusBall = sc.nextInt();
        }catch(InputMismatchException e){
            System.out.println("유효하지 않은 값입니다. 다시 값을 입력해주세요.");
        }
        return bonusBall;
    }


}

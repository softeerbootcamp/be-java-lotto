package kr.codesquad.View;

import kr.codesquad.Exception.InvalidLottoNumberException;
import kr.codesquad.Exception.InvalidManualLottoCountException;
import kr.codesquad.Exception.InvalidPriceException;
import kr.codesquad.Model.Lotto;
import kr.codesquad.Model.LottoNumber;
import kr.codesquad.Model.WinningLotto;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Input {
    static Scanner sc = new Scanner(System.in);
    public static int inputPrice(){
        // 예외처리 - 음수일 경우, 정수 입력이 아닐 경우
        // ?? - int 범위 벗어나는 것도 처리 해줘야 하나?
        //   -> int 범위가 넘어가면 InputMismatchException 으로 자동처리되긴 함 ㅋㅋ
        // 0일 때는? 돈을 들고 와라

        int price = 0;
        while(true) {
            try {
                Output.printGetPrice();
                price = sc.nextInt();
                if (price < 0) throw new InvalidPriceException("금액은 음수가 될 수 없습니다!!\n");
                if (price == 0) throw new InvalidPriceException("돈이 없으시네요 ㅠㅠ 돈 가지고 오세요\n");
                break;
            } catch (InputMismatchException inputMismatchException) {
                System.out.println("정수가 아닙니다 !! 정수를 입력해 주세요 !\n");
                sc.nextLine();
            } catch (InvalidPriceException invalidPriceException) {
                System.out.println(invalidPriceException.getMessage());
                sc.nextLine();
            }
        }
        return price;
    }

    public static Lotto inputWinLottoNum() {
        // 당첨 번호 입력 받기
        Output.printGetLastWinLottoNum();
        return inputLottoNum();
    }

    public static int inputManualLottoCount(int totalCount){
        // 예외처리 - 일단 개수이므로 0 이상이어야 하며 정수 이외 안됨

        int manualLottoCount = 0;
        while(true) {
            try {
                Output.printGetManuelLottoCount();
                manualLottoCount = sc.nextInt();
                if (manualLottoCount < 0) throw new InvalidManualLottoCountException("개수는 음수가 될 수 없습니다.");
                if (manualLottoCount > totalCount) throw new InvalidManualLottoCountException("살 수 있는 개수를 초과했습니다.");
                break;
            } catch (InputMismatchException inputMismatchException) {
                System.out.println("정수가 아닙니다 !! 정수를 입력해 주세요 !");
                sc.nextLine();
            } catch (InvalidManualLottoCountException InvalidManualLottoCountException) {
                System.out.println(InvalidManualLottoCountException.getMessage());
                sc.nextLine();
            }
        }
        return manualLottoCount;
    }

    public static List<Lotto> inputManuelLottoNum(int count){
        deleteNewLine();
        Output.printGetManuelLottoNum();
        List<Lotto> manuelLottos = new ArrayList<>();
        for(int i = 0;i < count;i++){
            manuelLottos.add(inputLottoNum());
        }
        return manuelLottos;
    }

    public static void deleteNewLine(){
        // 개행 제거
        sc.nextLine();
    }

    public static Lotto inputLottoNum(){
        // 예외 처리 - 숫자 부족할 때, 숫자가 아닐 때, 정해진 형식이 아닐 때, 중복값 입력일 때, 아무것도 없을 때
        while(true){
            try{
                int[] lotto = Arrays.stream(sc.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
                checkDuplicates(lotto);
                return Lotto.of(Arrays.stream(lotto).boxed().collect(Collectors.toList()));
            } catch (InvalidLottoNumberException invalidLottoNumberException) {
                System.out.println(invalidLottoNumberException.getMessage());
            } catch (NumberFormatException numberFormatException){
                System.out.println("번호를 제대로 입력해주세요\n");
            }
        }
    }

    public static void checkDuplicates(int[] lotto){
        if(lotto.length != Arrays.stream(lotto).distinct().count()) throw new InvalidLottoNumberException("중복이 있네요;;\n");
    }

    public static int inputBonusBall(){
        Output.printGetBonusBall();
        return sc.nextInt();
    }

    public static WinningLotto inputWinLottoNumAndBonusBall() {
        // 예외처리 - 로또 번호 조건이 맞는지와 중복 처리
        WinningLotto winningLotto;
        Lotto lotto = inputWinLottoNum();
        int bonusBall;

        while(true){
            try {
                bonusBall = inputBonusBall();
                winningLotto = new WinningLotto(lotto, bonusBall);
                break;
            } catch(InvalidLottoNumberException invalidLottoNumberException){
                System.out.println(invalidLottoNumberException.getMessage());
            } catch (InputMismatchException inputMismatchException) {
                System.out.println("정수가 아닙니다 !! 정수를 입력해 주세요 !\n");
                sc.nextLine();
            }
        }

        return winningLotto;
    }
}

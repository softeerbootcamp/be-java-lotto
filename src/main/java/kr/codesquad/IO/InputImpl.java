package kr.codesquad.IO;

import kr.codesquad.exception.*;
import kr.codesquad.lotto.LottoNumber;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class InputImpl implements Input {
    private final BufferedReader br;

    private static final InputExceptionHandler inputExceptionHandler = new InputExceptionHandlerImpl();

    public InputImpl(){
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public int moneyInput() {
        try {
            System.out.println("구입할 금액을 입력하세요");
            int money = Integer.parseInt(br.readLine());
            if(money < 0) {
                throw new InputOutOfRangeException();
            }
            return money;
        } catch (IOException e) {
            throw inputExceptionHandler.handleIOException(e);
        } catch (NumberFormatException | InputOutOfRangeException e) {
            throw inputExceptionHandler.handleNumberFormatExceptionAndInputOutOfRangeException();
        }
    }

    public int manualLottoCountInput() {
        try {
            System.out.println("수동으로 구매할 개수을 입력하세요");
            int manualCount = Integer.parseInt(br.readLine());
            if(manualCount < 0) {
                throw new InputOutOfRangeException();
            }
            return manualCount;
        } catch (IOException e) {
            throw inputExceptionHandler.handleIOException(e);
        } catch (NumberFormatException | InputOutOfRangeException e) {
            throw inputExceptionHandler.handleNumberFormatExceptionAndInputOutOfRangeException();
        }
    }

    @Override
    public List<List<LottoNumber>> manualLottoNumbersInput(int count) {
        try {
            List<List<LottoNumber>> manualLottoNumberLists = new ArrayList<>();
            if(count > 0) {
                System.out.println("수동으로 구입할 숫자를 입력하세요");

                for (int i = 0; i < count; i++) {
                    StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(), ", ");
                    List<LottoNumber> list = new ArrayList<>();
                    while (stringTokenizer.hasMoreTokens()) {
                        list.add(LottoNumber.of(Integer.parseInt(stringTokenizer.nextToken())));
                    }
                    manualLottoNumberLists.add(list);
                }
            }
            return manualLottoNumberLists;
        } catch (IOException e) {
            throw inputExceptionHandler.handleIOException(e);
        } catch (NumberFormatException | InputOutOfRangeException e) {
            throw inputExceptionHandler.handleNumberFormatExceptionAndInputOutOfRangeException();
        } catch (LottoNumberOutOfRangeException e) {
            throw inputExceptionHandler.handleLottoNumberOutOfRangeException(e);
        }
    }

    @Override
    public List<LottoNumber> jackpotNumberInput() {
        try {
            System.out.println("당첨 번호를 입력하세요");
            List<LottoNumber> jackpotLottoNumbers = new ArrayList<>();
            StringTokenizer stringTokenizer = new StringTokenizer(br.readLine(),", ");
            while(stringTokenizer.hasMoreTokens()) {
                jackpotLottoNumbers.add(LottoNumber.of(Integer.parseInt(stringTokenizer.nextToken())));
            }
            return jackpotLottoNumbers;
        } catch (IOException e) {
            throw inputExceptionHandler.handleIOException(e);
        } catch (NumberFormatException e) {
            throw inputExceptionHandler.handleNumberFormatExceptionAndInputOutOfRangeException();
        } catch (LottoNumberOutOfRangeException e) {
            throw inputExceptionHandler.handleLottoNumberOutOfRangeException(e);
        }
    }

    @Override
    public LottoNumber bonusNumberInput() {
        try {
            System.out.println("보너스 번호를 입력하세요");
            return LottoNumber.of(Integer.parseInt(br.readLine()));
        } catch (IOException e) {
            throw inputExceptionHandler.handleIOException(e);
        } catch (NumberFormatException e) {
            throw inputExceptionHandler.handleNumberFormatExceptionAndInputOutOfRangeException();
        } catch (LottoNumberOutOfRangeException e) {
            throw inputExceptionHandler.handleLottoNumberOutOfRangeException(e);
        }
    }
}

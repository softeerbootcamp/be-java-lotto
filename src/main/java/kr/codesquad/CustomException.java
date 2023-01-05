package kr.codesquad;

public class CustomException extends Exception{
    public CustomException (String moneyNotDividedClearly){
        super(moneyNotDividedClearly);
    }
}

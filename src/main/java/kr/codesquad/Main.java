package kr.codesquad;

public class Main {
    public static void main(String[] args) {
        App application = new App();
        try{
            application.play();
        } catch(StackOverflowError e) {
            System.out.println("형식에 벗어난 입력이 비정상적으로 많이 발생하였습니다.");
            System.out.println("프로그램을 종료합니다.");
        }
    }
}

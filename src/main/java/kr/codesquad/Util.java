package kr.codesquad;

public class Util {
    /*
     * Util class의 인스턴스화를 막기 위해 생성자를 private으로 설정
     * Util class 내부에서도 생성자를 사용하지 못하도록 예외 처리
     */
    private Util() throws InstantiationException {
        throw new InstantiationException();
    }
}

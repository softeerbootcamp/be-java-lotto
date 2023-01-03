package kr.codesquad;
import kr.codesquad.Controller.LottoController;
import kr.codesquad.Model.LottoService;

public class Main {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController();
        lottoController.start();
    }
}
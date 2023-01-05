package kr.codesquad.model;

public class UserInfo {

    private int numOfLottoAuto;  //로또 구매 개수 (기계)
    private int numOfLottoSudong;  //로또 구매 개수 (수동)
    private int purchasedPrice;   //로또 구매 금액

    public int getNumOfLottoAuto() {
        return numOfLottoAuto;
    }
    public int getNumOfLottoSudong() {
        return numOfLottoSudong;
    }
    public int getPurchasedPrice() {
        return purchasedPrice;
    }

    //setter 계산
    public void insertInfos(int purchasedPrice, int numOfLottoAuto, int numOfLottoSudong) {
        this.numOfLottoAuto = numOfLottoAuto;
        this.purchasedPrice = purchasedPrice;
        this.numOfLottoSudong = numOfLottoSudong;
    }
}

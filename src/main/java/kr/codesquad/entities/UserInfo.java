package kr.codesquad.entities;

public class UserInfo {

    private int numOfLottoAuto;  //로또 구매 개수 (기계)
    private int numOfLottoSudong;  //로또 구매 개수 (수동)
    private int purchasedPrice;   //로또 구매 금액
    private int bonus;  //입력한 보너스 번호

    public int getNumOfLottoAuto() {
        return numOfLottoAuto;
    }

    public void setNumOfLottoAuto(int numOfLottoAuto) {
        this.numOfLottoAuto = numOfLottoAuto;
    }

    public int getNumOfLottoSudong() {
        return numOfLottoSudong;
    }

    public void setNumOfLottoSudong(int numOfLottoSudong) {
        this.numOfLottoSudong = numOfLottoSudong;
    }

    public void setPurchasedPrice(int purchasedPrice){
        this.purchasedPrice = purchasedPrice;
    }

    public int getPurchasedPrice() {
        return purchasedPrice;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }
}

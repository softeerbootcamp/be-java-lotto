package kr.codesquad;

public class UserInfo {

    private int numOfLotto;  //로또 구매 개수
    private int purchasedPrice;   //로또 구매 금액
    private int bonus;  //입력한 보너스 번호

    public void setNumOfLotto(int numOfLotto){
        this.numOfLotto = numOfLotto;
    }

    public void setPurchasedPrice(int purchasedPrice){
        this.purchasedPrice = purchasedPrice;
    }

    public int getNumOfLotto() {
        return numOfLotto;
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

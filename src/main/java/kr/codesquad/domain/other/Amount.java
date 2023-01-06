package kr.codesquad.domain.other;

public class Amount {

    public final int amount;

    public Amount(int amount) {
        validateRange(amount);
        this.amount = amount;
    }

    public Amount(Amount totalAmount, int amount) {
        validateRange(totalAmount.getAmount() - amount);
        validateRange(amount);
        this.amount = amount;
    }

    private void validateRange(int amount) {
        if(amount < 0) {
            throw new IllegalArgumentException("[error] 수동 로또를 구매할 수 없습니다.");
        }
    }

    public int getAmount() {
        return amount;
    }
}

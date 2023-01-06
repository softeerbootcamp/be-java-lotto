package kr.codesquad.Enum;

public enum Prizes_Info {

    THREE(5000) {
        public void printPrizeByFlag(int flag) {

            System.out.printf("3개 일치 (5000원) -%d개\n", flag);
        }
    },
    FOUR(50000) {
        public void printPrizeByFlag(int flag) {
            System.out.printf("4개 일치 (50000원) -%d개\n", flag);
        }
    },
    FIVE(1500000) {
        public void printPrizeByFlag(int flag) {
            System.out.printf("5개 일치 (1500000원) -%d개\n", flag);
        }
    },
    BONUS(30000000) {
        public void printPrizeByFlag(int flag) {
            System.out.printf("5개 일치, 보너스 볼 일치 (30000000원) -%d개\n", flag);
        }
    },
    SIX(2000000000) {
        public void printPrizeByFlag(int flag) {
            System.out.printf("6개 일치 (2000000000원) -%d개\n", flag);
        }

    };
    private int value;

    Prizes_Info(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public abstract void printPrizeByFlag(int flag);

}

package kr.codesquad;

public enum Prizes {
        THREE{
            public int print_prize() {
                return 5000;
            }
            public void print_message() {
                System.out.println("3개 일치 (5000원) -");
            }
        },
        FOUR{
            public int print_prize() {
                return 50000;
            }
            public void print_message() {
                System.out.println("4개 일치 (50000원) -");
            }
        },
        FIVE{
            public int print_prize() {
                return 1500000;
            }
            public void print_message() {
                System.out.println("5개 일치 (1500000원) -");
            }
        },
        BONUS{
            public int print_prize() {
                return 30000000;
            }
            public void print_message() {
                System.out.println("5개 일치, 보너스 볼 일치 (30000000원) -");
            }
        },
        SIX{
            public int print_prize() {
                return 30000000;
            }
            public void print_message() {
                System.out.println("5개 일치 (1500000원) -");
            }

        };
        public abstract int print_prize();
        public abstract void print_message();

}

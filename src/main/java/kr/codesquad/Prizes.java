package kr.codesquad;

public enum Prizes {
        THREE{
            public int print_prize() {
                return 5000;
            }
            public void print_message(int flag) {
                System.out.printf("3개 일치 (5000원) -%d개\n",flag);
            }
        },
        FOUR{
            public int print_prize() {
                return 50000;
            }
            public void print_message(int flag) {
                System.out.printf("4개 일치 (50000원) -%d개\n",flag);
            }
        },
        FIVE{
            public int print_prize() {
                return 1500000;
            }
            public void print_message(int flag) {
                System.out.printf("5개 일치 (1500000원) -%d개\n",flag);
            }
        },
        BONUS{
            public int print_prize() {
                return 30000000;
            }
            public void print_message(int flag) {
                System.out.printf("5개 일치, 보너스 볼 일치 (30000000원) -%d개\n",flag);
            }
        },
        SIX{
            public int print_prize() {
                return 30000000;
            }
            public void print_message(int flag) {
                System.out.printf("5개 일치 (1500000원) -%d개\n",flag);
            }

        };
        public abstract int print_prize();
        public abstract void print_message(int flag);

}

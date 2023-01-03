package kr.codesquad;

public enum Prizes {
        THREE{
            public int print_prize() {
                return 5000;
            }
        },
        FOUR{
            public int print_prize() {
                return 50000;
            }
        },
        FIVE{
            public int print_prize() {
                return 1500000;
            }
        },
        BONUS{
            public int print_prize() {
                return 30000000;
            }
        },
        SIX{
            public int print_prize() {
                return 30000000;
            }
        };
        public abstract int print_prize();

}

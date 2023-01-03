package kr.codesquad;

public enum Fee {

    FIRST(6,2000000000, "6개 일치 (2000000000원)"),
    SECOND(777,30000000, "5개 일치, 보너스 볼 일치 (30000000원)"),
    THIRD(5,1500000, "5개 일치 (1500000원)"),
    FOURTH(4,50000, "4개 일치 (50000원)"),
    FIFTH(3,5000, "3개 일치 (5000원)");

    private Integer numOfItem;
    private Integer price;
    private String script;

    private Fee(Integer numOfItem, Integer price, String script){
        this.price = price;
        this.numOfItem = numOfItem;
        this.script = script;
    }

    public Integer getPrice(){
        return price;
    }

    public Integer getNumOfItem(){
        return numOfItem;
    }

    public String getScript(){
        return script;
    }
}

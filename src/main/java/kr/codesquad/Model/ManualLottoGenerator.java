package kr.codesquad.Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ManualLottoGenerator implements LottosGenerator{
    int count;
    List<Lotto> lottos;

    public ManualLottoGenerator(int count, List<Lotto> lottos){
        this.count = count;
        this.lottos = lottos;
    }

    public List<Lotto> generate(){
        return lottos;
    }

}

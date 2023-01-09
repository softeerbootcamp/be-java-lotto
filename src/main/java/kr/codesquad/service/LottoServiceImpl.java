package kr.codesquad.service;

import kr.codesquad.domain.Result;
import kr.codesquad.domain.lotto.AnswerLotto;
import kr.codesquad.domain.lotto.Lotto;
import kr.codesquad.domain.PurchaseRecord;
import kr.codesquad.generator.condition.ConditionGeneratorProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoServiceImpl implements LottoService {

    private final ConditionGeneratorProvider cgp;

    public LottoServiceImpl(ConditionGeneratorProvider cgp) {
        this.cgp = cgp;
    }

    @Override
    public PurchaseRecord getPurchaseRecord(Integer money, Integer manualLottoCount) {
        return PurchaseRecord.getNew(money, manualLottoCount);
    }

    @Override
    public List<Lotto> getLottos(PurchaseRecord purchaseRecord, List<List<Integer>> manualNumbers) {
        List<Lotto> lottos = new ArrayList<>();
        lottos.addAll(getManualLotto(manualNumbers));
        lottos.addAll(getAutoLotto(purchaseRecord));
        return lottos;
    }

    private List<Lotto> getManualLotto(List<List<Integer>> manualNumbers) {
        return manualNumbers.stream()
                .map(manualNumber -> new Lotto(manualNumber))
                .collect(Collectors.toList());
    }

    private List<Lotto> getAutoLotto(PurchaseRecord purchaseRecord) {
        List<Lotto> lottos = new ArrayList<>();
        int numOfAutoLotto = purchaseRecord.getNumOfLotto() - purchaseRecord.getNumOfManualLotto();
        for (int count = 0; count < numOfAutoLotto; count++) {
            lottos.add(new Lotto());
        }
        return lottos;
    }

    @Override
    public AnswerLotto getAnswerLotto(List<Integer> answerNumbers, Integer bonusNumber) {
        return new AnswerLotto(answerNumbers, bonusNumber);
    }

    @Override
    public Result getResult(List<Lotto> lottos, AnswerLotto answerLotto, PurchaseRecord purchaseRecord) {
        return Result.getNew(lottos, answerLotto, purchaseRecord);
    }
}

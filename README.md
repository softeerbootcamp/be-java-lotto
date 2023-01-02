# Java Lotto

- Last Update: 2022-12-28

## 코드 리뷰

* [텍스트와 이미지로 살펴보는 코드스쿼드의 온라인 코드 리뷰 과정](https://github.com/code-squad/codesquad-docs/blob/master/codereview/README.md)

* [동영상으로 살펴보는 코드스쿼드의 온라인 코드 리뷰 과정](https://youtube.com/watch?v=lFinZfu3QO0&si=EnSIkaIECMiOmarE)

## 기능 리스트 
- [ ] 로또번호 생성 기능  - NumberGenerator#numberGenerate()
- [ ] 로또 금액 입력 받는 기능  - InputView#InputMoney() 
- [ ] 입력받은 금액으로 구매가능한 로또 갯수 계산 기능 - Lotto#calculateCount()
- [ ] 구매한 로또 개수 출력 기능 - OutputView#printLottoCount()
- [ ] 구매한 로또 번호 출력 기능 - OutputView#printLottoNumbers()
- [ ] 당첨번호 입력 텍스트 출력 기능 - OutputView#printWinningNumberText()
- [ ] 당첨번호 입력 기능 - InputView#inputWinningNumbers()
- [ ] 당첨 통계 출력 기능 - OutputView#printTotal()
  - [ ] 일치 개수 계산기능 - Lotto#calculateContainsCount()
  - [ ] 수익률 계산 기능 - Lotto#calculateRateOfReturn()
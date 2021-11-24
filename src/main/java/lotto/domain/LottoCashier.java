package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoCashier {

    private static final int MIN_LOTTO_BUY_PRICE = 1000;

    public int calculateCountAvailable(int money) {
        validate(money);
        return money / LottoShop.LOTTO_PRICE;
    }

    private void validate(int money) {
        if (money < MIN_LOTTO_BUY_PRICE) {
            throw new IllegalArgumentException("해당 금액으로는 로또를 사실 수 없습니다.");
        }
    }

    public List<Lotto> pay(int money) {
        int lottoCount = calculateCountAvailable(money);

        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(new Lotto());
        }

        return lottos;
    }

}

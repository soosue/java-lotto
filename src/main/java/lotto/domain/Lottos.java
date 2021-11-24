package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottos {

    private static final int MIN_COUNT = 0;

    private final List<Lotto> lottos;

    public Lottos(int count) {
        if (count < MIN_COUNT) {
            throw new IllegalArgumentException("로또 개수는 0 미만일 수 없습니다.");
        }

        lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(new Lotto());
        }
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }
}

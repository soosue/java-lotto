package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {

    @Test
    @DisplayName("원하는 개수 만큼 로또 구입")
    void create() {
        int lottoCount = 14;
        Lottos lottos = new Lottos(lottoCount);

        assertThat(lottos.getLottos()).hasSize(lottoCount);
    }

}

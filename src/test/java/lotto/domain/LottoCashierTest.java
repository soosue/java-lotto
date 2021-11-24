package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoCashierTest {
    private final LottoCashier lottoCashier = new LottoCashier();

    @DisplayName("구매 가능한 로또 개수 계산하기")
    @ParameterizedTest
    @CsvSource(value = {"0,0", "500,0", "1000,1"})
    void calculateCountAvailable(int money, int availableLottoCount) {
        assertThat(lottoCashier.calculateCountAvailable(money))
                .isEqualTo(availableLottoCount);
    }

    @DisplayName("구매 가능한 로또 개수 계산하기 - 음수")
    @Test
    void calculateCountAvailableFail() {
        assertThatThrownBy(() -> lottoCashier.calculateCountAvailable(-1000))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("해당 금액으로는 로또를 사실 수 없습니다.");
    }
}

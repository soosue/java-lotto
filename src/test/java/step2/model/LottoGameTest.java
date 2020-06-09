package step2.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoGameTest {

    @ParameterizedTest
    @CsvSource(value={"1005:1", "4800:4", "7900:7", "50400:50"}, delimiter = ':')
    @DisplayName("입력한 금액 대비 구입할수 있는 개수")
    void getLottoCount(int money, int result) {
        LottoGame lottoGame = new LottoGame(money);
        assertThat(lottoGame.getLottoCount()).isEqualTo(result);
    }
}
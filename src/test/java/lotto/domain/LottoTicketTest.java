package lotto.domain;

import lotto.common.WinningType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LottoTicketTest {
    @Test
    @DisplayName("로또 티켓 winningType 테스트")
    void checkWinningType() {
        WinningType winningType;
        LottoTicket winningLottoTicket = new LottoTicket("1,2,3,4,5,6");
        int bonusNumber = 7;

        // 6개 모두 일치 시에는 1등
        LottoTicket userFirstLottoTicket = new LottoTicket("1,2,3,4,5,6");
        winningType = userFirstLottoTicket.getWinningType(winningLottoTicket);
        assertThat(winningType).isEqualTo(WinningType.FIRST);

        //2등은 보너스 번호가 포함되어있고, 5개 로또번호가 일치하는 경우이다.
        LottoTicket userSecondLottoTicket = new LottoTicket("1,2,3,4,5,7");
        assertThat(userSecondLottoTicket.getWinningType(winningLottoTicket, bonusNumber)).isEqualTo(WinningType.SECOND);

        //3등은 5개 로또번호가 일치하는 경우이다.
        LottoTicket userThirdLottoTicket = new LottoTicket("1,2,3,4,5,8");
        assertThat(userThirdLottoTicket.getWinningType(winningLottoTicket, bonusNumber)).isEqualTo(WinningType.THIRD);

        //4등은 3개 로또번호가 일치하는 경우이다.
        LottoTicket userForthLottoTicket = new LottoTicket("1,2,3,14,15,16");
        winningType = userForthLottoTicket.getWinningType(winningLottoTicket);
        assertThat(winningType).isEqualTo(WinningType.FORTH);

        //8등은 0개 로또번호가 일치하는 경우이다.
        LottoTicket userSeventhLottoNumbers = new LottoTicket("11,12,13,14,15,16");
        winningType = userSeventhLottoNumbers.getWinningType(winningLottoTicket);
        assertThat(winningType).isEqualTo(WinningType.EIGHTH);
    }
}

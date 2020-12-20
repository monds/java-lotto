package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoTest {

    @Test
    @DisplayName("로또 생성")
    void testCreateLotto() {
        // given
        String input = "6,2,3,4,5,1";
        // when
        Lotto lotto = Lotto.of(input);
        // then
        assertThat(lotto.toArray()).isEqualTo(new int[] {1, 2, 3, 4, 5, 6});
    }

    @Test
    @DisplayName("콤마가 아닌 구분자로 로또 생성 시 예외")
    void testCreateLottoWithOtherDelimiter() {
        assertThatIllegalArgumentException().isThrownBy(() -> Lotto.of("1:2:3:4:5:6"));
    }

    @Test
    @DisplayName("로또 번호 개수가 6개 미만일 경우 예외")
    void testCreateLottoLessThanSix() {
        assertThatIllegalArgumentException().isThrownBy(() -> Lotto.of("1,2,3"));
    }

    @Test
    @DisplayName("매치 개수")
    void testLottoCountOfMatchAll() {
        // given
        Lotto lotto = Lotto.of("1,2,3,4,5,6");
        Lotto winningLotto = Lotto.of("1,2,3,4,5,6");
        // when
        int countOfMatch = lotto.countOfMatch(winningLotto);
        // then
        assertThat(countOfMatch).isEqualTo(6);
    }
}

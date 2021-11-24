package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumber implements Comparable<LottoNumber> {

    private static final int MIN_VALUE = 1;
    public static final int MAX_VALUE = 45;

    private static final List<LottoNumber> lottoNumbers = new ArrayList<>();
    static {
        for (int i = MIN_VALUE; i <= MAX_VALUE; i++) {
            lottoNumbers.add(new LottoNumber(i));
        }
    }

    private final int value;

    public LottoNumber(int value) {
        validate(value);
        this.value = value;
    }

    private void validate(int value) {
        if (value < MIN_VALUE || value > MAX_VALUE) {
            throw new IllegalArgumentException("해당 번호의 로또번호는 없습니다.");
        }
    }

    public static List<LottoNumber> getRandomNumber(int count) {
        List<LottoNumber> tmpLottoNumbers = new ArrayList<>(LottoNumber.lottoNumbers);
        Collections.shuffle(tmpLottoNumbers);

        List<LottoNumber> lottos = tmpLottoNumbers.subList(0, count);
        Collections.sort(lottos);
        return lottos;
    }

    public int value() {
        return value;
    }

    @Override
    public int compareTo(LottoNumber o) {
        return Integer.compare(value, o.value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LottoNumber that = (LottoNumber) o;

        return value == that.value;
    }

    @Override
    public int hashCode() {
        return value;
    }

}

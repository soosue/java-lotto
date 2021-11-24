package lotto.domain;

import lotto.util.RandomUtil;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {

    public static final int NUMBER_COUNT = 6;


    private final List<LottoNumber> lottoNumbers;

    public Lotto() {
        this(pickRandomNumber(NUMBER_COUNT));
    }

    private static List<LottoNumber> pickRandomNumber(int numberCount) {
        Set<LottoNumber> tmpLottoNumbers = new HashSet<>();
        while (tmpLottoNumbers.size() < numberCount) {
            tmpLottoNumbers.add(new LottoNumber(RandomUtil.randomInt(LottoNumber.MAX_VALUE)));
        }

        List<LottoNumber> lottoNumbers = new ArrayList<>(tmpLottoNumbers);
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }

    public Lotto(final String numbers) {
        this(Arrays.stream(numbers.split(","))
                .map(String::trim)
                .mapToInt(Integer::parseInt)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList()));
    }

    public Lotto(final List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != NUMBER_COUNT) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }
        this.lottoNumbers = lottoNumbers;
    }

    public int countMatch(Lotto winLotto) {
        return (int) lottoNumbers.stream()
                .filter(lottoNumber -> winLotto.lottoNumbers.contains(lottoNumber))
                .count();
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

}

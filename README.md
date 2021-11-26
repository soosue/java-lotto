# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 로또(2등) 추가 기능 요구사항
* 2등을 위해 추가 번호를 하나 더 추첨한다.
* 당첨 통계에 2등도 추가해야 한다.

## 로또(2등) 추가 구현할 기능 목록
* 보너스 볼을 입력
  - 당첨 번호와 중복되면 안됨
* 로또가 보너스볼을 맞췄는지 확인
* 일치 개수에 따른 등수 2등 추가
* 일치 개수에 따른 등수 집계 2등 추가

## 로또(자동) 기능 요구사항
* 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
* 로또 1장의 가격은 1000원이다.

## 로또(자동) 구현할 기능 목록
* 숫자를 입력받아 살 수 있는 로또 개수 계산           완료 LottoCashier
  - 0 또는 양수만 가능(음수 x)
  - 거스름돈 계산(1500원 넣으면 1개만 구매)
* 원하는 개수 만큼 로또 구입                       완료 Lottos
* 자동 번호로 로또 구매                            절반 Lotto테스트x, LottoNumber테스트o
* 숫자를 입력하여 로또 구매                        완료 Lotto의 책임
  - ,구분자로 문자를 숫자로 변환
  - 6개의 1~45사이 숫자
  - 중복x
  - 숫자 이외의 다른 입력x
* 당첨 번호와 로또를 비교하여 일치하는 개수 반환      완료 Lotto의 책임
* 일치 개수에 따른 등수 반환                       완료 Rank의 책임.
* 일치 개수에 따른 등수 집계?                      절반 테스트x Lottos의 책임. 다른 도메인(Lotto와 Ranks)들에게 위임하여 수행
* 수익률 계산                                    Ranks가 책임.(의미적으로 Result라는 도메인을 만들어서 일급컬렉션인 Ranks와, rateOfProfit변수를 가져야하는게 아닌가 생각)
* UI 금액 입력
* UI 구매한 로또 출력
* UI 당첨 번호 입력
* UI 당첨 결과 출력

## 로또(자동) 리뷰 내용
* 문맥에서 유추 가능한 이름은 네이밍에서 생략
* get- 안 쓰기
* 어떤 책임을 줄 때, 책임에 대한 정보를 가장 많이 아는 친구에게 맡겨라.
* 메서드 레퍼런스 사용
* 정말 간단한 테스트 코드가 아닌 이상 @DisplayName를 사용하는게 이해하기 쉽다.
## 로또(자동) 리뷰 내용2
* 생성자도 접근제어자가 있다. 밖으로 노출시켜서 안된다면 private으로 줘라.
* enum 변수도 변수다. final을 붙여주자.
* 한 도메인이 하는 역할이 다른 도메인의 역할을 바이패스만 하고 있다면, 불필요한게 아닌가 의심하라.
* 상수가 아닌 숫자와 문자열은 매직 넘버, 매직 스트링으로 불린다. 이들은 의미를 파악하기가 쉽지 않게 된다. 상수로 만들어 의미를 부여해주자.
* 배열보다는 리스트를 사용하라. 코드가 다소 복잡해지고, 성능이 살짝 나빠질 수는 있지만, 안전성과 상호 운용성이 좋아진다.
* 컬렉션(자료구조)에게 의미와 이름을 주고, 연관된 책임을 맡게 할 수 있는게 일급컬렉션이다.
* 값을 계산할 수 있다면, 굳이 값을 저장해놓을 필요는 없다.(물론 계산 비용이 크고 호출이 잦다면, 처음에 저장하는게 좋다)
* 예외는 가능한 체크해주는 것이 좋다.
## 로또(자동) 리뷰 내용3
* 생성자 대신 정적 팩토리 메서드 사용하기 - 생성자에 의미(이름)를 부여할 수 있게 된다.


## 문자열 덧셈 계산기 기능 요구사항
* 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환 (예: ""=>0, "1,2"=>3, "1,2,3"=>6, "1,2:3"=>6)
* 앞의 기본 구분자(쉼표,콜론)외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 "//"와 "\n"사이에 위치하는 문자를 커스텀 구분자로 사용한다. 예를 들어 "//;\n1;2;3"과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
* 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 throw한다.

## 문자열 덧셈 계산기 리뷰 내용
* 생성자는 많을 수록 활용도가 높다.
* get- 이라는 용어는 getter의 의미가 강하니 메서드의 네이밍할 때, 다른 용어를 사용하자.
* 중복이 있다면, 줄일 방법을 생각해라.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)
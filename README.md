# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

## 요구사항 정리
### Domain
- [X] 자동차이름을 의미하는 클래스(CarName) 구현
  - [X] 자동차의 이름이 5자 초과하면 예외 발생
  - [X] 자동차의 이름이 null 또는 빈문자이면 예외 발생
- [X] 자동차위치 또는 게임 횟수를 저장할 수 있는 양수를 의미하는 추상클래스(PositiveNumber) 구현
  - [X] 위치가 음수이면 예외 발생
  - [X] 0의 가능여부를 반환하는 추상메서드 작성
- [X] 자동차위치를 의미하는 클래스(CarPosition) 구현
- [X] 게임횟수를 의미하는 클래스(GameTryCount) 구현
  - [X] 게임종료여부 기능 구현 
- [X] 자동차의 이름과 위치를 가진 클래스(Car) 구현
  - [X] 전진 기능(forward) 구현
  - [X] 전략 설정 기능 구현
- [X] 자동차 클래스의 일급콜렉션을 의미하는 클래스(Cars) 구현
  - [X] 전진 기능 구현
  - [X] 전략 설정 기능 구현
  - [X] 우승자 결정 기능의 구현
- [X] 자동차 데이터 전달용 클래스(CarDto)의 구현
- [X] 자동차 전진 전략을 결정하기 위한 인터페이스(MovableStrategy) 구현
- [X] 랜덤 전진 전략 클래스(RandomlyMovableStrategy) 구현
- [X] 무조건 전진 전략 클래스(AlwaysMovableStrategy) 구현
- [X] 무조건 정지 전략 클래스(NoMovableStrategy) 구현
- [X] N번마다 이동 전략 클래스(EveryNTimesMovableStrategy) 구현

### View
- [X] 입력 관리 클래스(InputView) 구현
  - [X] 자동차 이름을 입력 기능 구현
  - [X] 게임을 시도할 횟수 입력 기능 구현
- [X] 출력 관리 클래스(ResultView) 구현
  - [X] 실행결과 출력 기능 구현
  - [X] 우승자 출력 기능 구현

### Controller
- [X] 게임 진행을 관리하는 클래스(GameController) 구현
  - [X] 자동차이름 입력시 오류에 대한 재입력 기능 구현
  - [X] 게임횟수 입력시 오류에 대한 재입력 기능 구현

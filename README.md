# java-blackjack

## 블랙잭 규칙

- 게임 시작 시 딜러를 포함한 플레이어들은 카드를 2장씩 받는다.

> 처음 받은 2장의 손패의 스코어가 21인 경우를 블랙잭이라고 한다.

- 딜러가 블랙잭인 경우 결과를 반환하고 게임을 종료한다. 
    - 블랙잭인 플레이어들은 무승부 
    - 나머지 플레이어들은 패배
- 플레이어가 블랙잭인 경우 해당 플레이어는 게임에서 승리한다.
- 딜러는 첫 손패 중 카드 1장, 플레이어들은 카드 2장을 다 보여준다.
- 플레이어는 손패가 버스트 되기 전까지 카드를 Draw 할 수 있다.
    - 버스트가 나면 딜러와 상관 없이 무조건 패배
- 딜러 카드 숫자 합이 16 이하 일 경우 딜러는 계속 Draw 해야 한다.
    - 딜러의 베스트 스코어를 기준으로 판단
- 딜러와 플레이어가 1:1 씩 승패를 가른다.
    - 21 이하 이면서 가장 21에 가까운 손패를 가진 쪽이 승리한다.

## 블랙잭 기능목록

- [x] 게이머들의 이름을 입력받는 기능
    - [x] 이름은 공백 이거나 빈칸 만으로 이루어 질 수 없다.
- [x] 딜러와 게임 게이머들에게 카드를 나눠주는 기능
- [x] 딜러와 게이머가 받은 카드들을 출력하는 기능
- [x] 게이머들이 카드를 더 받는 기능
    - [x] 입력한 이름 순서대로 카드 더 받는 과정을 수행한다.
    - [x] 카드를 더 받기 전에 게이머의 손패가 블랙잭 혹은 버스트인지 확인한다.
    - [x] 게이머가 카드를 더 받을지 결정하는 기능
    - [x] 게이머가 카드를 더 받았을 때 현재 보유 카드들을 출력하는 기능
- [x] 딜러가 카드를 더 받는 기능
    - [x] 모든 게이머가 버스트라면 카드를 더 받지 않는다.
    - [x] 딜러 카드 숫자합이 16이하일 경우 카드를 한 장 더 받는다.
- [x] 딜러와 게이머의 최종 점수를 출력하는 기능
    - [x] 각자가 가진 카드를 출력한다.
    - [x] 카드 숫자합을 출력한다.
        - [x] 출력하는 카드 숫자합은 21에 가장 가까운 숫자를 출력한다.
- [x] 최종 승패를 출력하는 기능

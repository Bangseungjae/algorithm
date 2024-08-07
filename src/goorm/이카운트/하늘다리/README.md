## 문제

이카운트 나라에는 N개의 산이 나열된 산맥이 있다. 산은 순서대로 1번 부터 N번 까지의 번호가 붙어있고, i번 산의 높이는 Hi이다.

새로운 관광 상품을 위해 두 산의 정산을 잇는 하늘다리를 하나 설치하려고 한다.
하늘다리를 설치하기 위해선 두 산의 높이가 같아야 하고, 두 산 사이에 있는 모든 산들의 높이가 다른 다리를 설치하려는 산의 높이보다 작아야 한다.

하늘 다리를 설치할 수 있는 서로 다른 방법은 몇 가지가 있을지 구해보자.

예를 들어, 산의 높이가 5 2 3 2 5라 해보자.

높이가 2인 산은 높이가 3인 산이 가로막아 하늘다리를 설치할 수 없고,
높이가 5인 산은 사이에 가로막는 산이 없어 하늘다리를 설치할 수 있다.

따라서 설치할 수 있는 하늘다리는 총 1개이다.

## 입력
첫째 줄에 산의 수 N이 주어진다.

둘째 줄에 산의 높이 H1, H2, ... Hn가 공백을 두고 주어진다.
- 2 <= N <= 300 000
- 1 <= Hi <= 10^9
- 입력에서 주어지는 모든 수는 정수이다.

## 출력
설치할 수 있는 하늘다리의 총개수.

### 예시 1
입력
```text
5
5 2 3 2 5
```

출력
```text
1
```

### 예시 2
입력 
```text
9
5 4 3 2 1 2 3 4 5
```

출력
```text
4
```

### 예시 3
입력
```text
4
2 2 2 2
```

출력
```text
3
```

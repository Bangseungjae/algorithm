java 언어로 코딩테스트 문제 풀어줘.

양궁 대회 우승하기

제한 조건
•	언어 및 제한 사항
•	Go: 1초, 1024MB
•	Java: 1초, 1024MB
•	Python: 1초, 1024MB

문제 설명

H 회사에서는 워크샵 활동 중 하나로 양궁 대회를 개최하기로 하였습니다. 해당 양궁 대회는 다음과 같은 규칙을 가지고 있습니다.
1.	과녁의 크기는 N × N 크기의 격자입니다.
2.	각 격자 칸마다 얻을 수 있는 점수가 적혀 있습니다.
3.	총 K개의 화살이 존재합니다. 각 화살은 1부터 K까지 하나씩 존재합니다.
4.	만약 크기가 i인 화살을 i번째 화살의 중심에 맞춰 발사하면, 맞춘 칸으로부터 거리가 i 이내인 모든 격자의 점수를 얻게 됩니다.
•	격자 칸 (x₁, y₁) 과 (x₂, y₂) 사이의 거리는
|x₁ - x₂| + |y₁ - y₂| 로 정의됩니다.
5.	크기가 i인 화살을 발사할 때 B[i] 만큼의 힘이 필요합니다.
6.	이미 발사한 화살은 다시 사용할 수 없습니다.

목표

철수는 대회에서 정확히 P점을 얻고 싶습니다.
이를 위해 필요한 힘의 최소값을 구하는 프로그램을 작성하세요.
만약 어떤 방법을 사용해도 P점을 정확히 얻을 수 없다면 -1을 출력하세요.

제약 조건
•	1 ≤ N ≤ 10
•	1 ≤ K ≤ N
•	1 ≤ P ≤ 10,000
•	1 ≤ 격자에 적힌 점수 ≤ 100
•	1 ≤ B[i] ≤ 100,000

입력 형식
1.	첫 번째 줄에 격자의 가로, 세로 길이 N, 화살의 종류 K, 철수의 목표 점수 P가 공백을 사이에 두고 주어집니다.
2.	두 번째 줄부터 N개의 줄에 걸쳐 격자 각 칸의 점수가 공백을 사이에 두고 주어집니다.
•	각 줄은 N개의 정수로 이루어져 있습니다.
3.	그 다음 줄에 화살을 발사할 때 필요한 힘 K개가 공백을 사이에 두고 주어집니다.
•	B[1]부터 B[K]까지가 순서대로 주어집니다.

출력 형식
•	첫 번째 줄에 점수를 정확히 P점을 맞추기 위해 필요한 힘의 최소값을 출력하세요.
•	만약 어떤 방법으로도 P점을 얻을 수 없다면 -1을 출력하세요.

입력 예제 1

3 2 8
1 1 1
1 1 1
1 1 3
1 2

출력 예제 1

3

설명:
•	크기가 1인 화살과 2인 화살을 모두 (3,3) 격자 칸에 발사하면, 정확히 8점을 얻을 수 있습니다.

입력 예제 2

4 4 319
1 1 1 1
1 1 1 1
1 1 1 100
1 1 1 1
1 2 4 6

출력 예제 2

11

입력 예제 3

3 2 15
1 3 1
3 1 3
1 3 1
1 2

출력 예제 3

-1

설명:
•	어떻게 하더라도 정확히 15점을 얻을 수 없습니다. ￼
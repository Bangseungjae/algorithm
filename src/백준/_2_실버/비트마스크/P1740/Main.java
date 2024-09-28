package 백준._2_실버.비트마스크.P1740;

import java.io.*;

public class Main {
    // 3^i를 계산하는 함수
    static long powerOfThree(int i) {
        long result = 1;
        for (int j = 0; j < i; j++) {
            result *= 3;
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());

        long answer = 0;

        for (int i = 0; i < 64; i++) {
            if ((1L << i & n) != 0) { // n의 i번째 비트가 1인지 확인
                answer += powerOfThree(i); // 3^i를 answer에 추가
                n -= (1L << i); // n에서 (1L << i)를 빼줌
            }
        }
        System.out.println(answer);
    }
}


/*
 * 3의 제곱수를 생각하자. 3의 0제곱, 3의 1제곱, 3의 2제곱, ... 은 순서대로 1, 3, 9, 27, ... 이 된다.
 * 이를 바탕으로, 한 개 이상의 서로 다른 3의 제곱수의 합으로 표현되는 수를 생각할 수 있다. 예를 들어 30은 27과 3의 합이므로, 이러한 수에 포함된다.
 * 한 개 이상의 서로 다른 3의 제곱수의 합으로 표현되는 N번째로 작은 수를 구하는 프로그램을 작성하시오.

 * 입력
 * 첫째 줄에 N이 주어진다. N은 500,000,000,000 이하의 자연수이다. (5000억)

 * 출력
 * 첫째 줄에 한 개 이상의 서로 다른 3의 제곱수의 합으로 표현되는 N번째로 작은 수를 출력한다.

 * ex) input: 4 -> output -> 9, input: 1 -> 1
 *
 * 우리는 N번째로 작은 수를 찾아야 합니다. 그럼 먼저 서로 다른 3의 제곱수의 합으로 나타낼 수 있는 수들을 나열해 보겠습니다:

1. 1 (3^0)
2. 3 (3^1)
3. 4 (3^0 + 3^1)
4. 9 (3^2)
 */


// 5
// 1 0 1
// 4
// 1 0 0

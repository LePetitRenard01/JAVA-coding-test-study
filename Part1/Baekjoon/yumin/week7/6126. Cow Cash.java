import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int V = sc.nextInt();
        int N = sc.nextInt();
        int[] coins = new int[V];

        for (int i = 0; i < V; i++) {
            coins[i] = sc.nextInt();
        }

        // dp[i]: 금액 i를 만들 수 있는 경우의 수
        int[] dp = new int[N + 1];
        dp[0] = 1; // 금액 0은 아무것도 선택하지 않는 1가지 경우만 가능

        // 동전 조합으로 dp 배열 채우기
        // 내부 for문: 현재 코인을 사용하여 만들 수 있는 모든 금액 i
        // i - coin: 현재 코인을 사용하고 남은 금액
        for (int coin : coins) {
            for (int i = coin; i <= N; i++) {
                dp[i] += dp[i - coin];
            }
        }

        System.out.println(dp[N]); // 목표 금액을 만들 수 있는 경우의 수 출력
    }
}
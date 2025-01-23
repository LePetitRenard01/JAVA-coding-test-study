import java.io.*;

public class BOJ_1463 {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];
        dp[1] = 0;

        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + 1; // 항상 가능 -> 먼저 시도

            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1); // % 2와 -1 연산 비교
            }
            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1); // % 3와 -1 연산 비교
            }
        }
        System.out.println(dp[N]);
    }
}

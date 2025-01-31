import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] val = new int[n+1];
        int[] dp = new int[k+1];

        for (int i = 1; i <= n; i++) {
            // 동전 입력
            val[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = 1; // 초기화

        // 동전마다 k번의 경우의 수 생김
        for (int i = 1; i <= n; i++) {
            // val[i] 가치의 동전으로 k만큼의 가치를 만들수 있는 경우
            for (int j = val[i]; j <= k; j++) {
                dp[j] += dp[j - val[i]];
            }
        }

        System.out.println(dp[k]);
    }
}
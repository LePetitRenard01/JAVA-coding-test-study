import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int[] price = new int[n+1]; // 가격 배열
        int[] dp = new int[n+1];    // dp 배열
        for (int i = 1; i <= n; i++) {
            price[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                // dp[i]: i장까지의 최대 가격
                // dp[i-j]: j장을 제외했을때의 확정된 최대 가격
                dp[i] = Math.max(dp[i], dp[i-j]+price[j]);
            }
        }

        System.out.println(dp[n]);
    }
}
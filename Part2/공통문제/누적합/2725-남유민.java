import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int[] dp = new int[1001];
        dp[1] = 3; // 초기값

        // dp 채우기
        for (int i = 2; i < 1001; i++) {
            int point = 0;
            for (int j = 1; j < i; j++) {
                if (gcd(i, j) == 1) point++;
            }
            dp[i] = dp[i-1] + point * 2;
        }

        int c = Integer.parseInt(br.readLine());
        while (c-- > 0) {
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[n]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }

    static int gcd(int a, int b) {
        // gcd(a, b) = gcd(b, a % b) = 큰 수를 작은 수로 나눔
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a; // b가 0이 되었다는 뜻
    }
}
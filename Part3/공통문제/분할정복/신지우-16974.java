import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static long X;
    static long[][] dp;

    // 번- n-1버거 - 패티 - n-1버거 - 번
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        X = Long.parseLong(st.nextToken());
        dp = new long[N + 1][2]; //total, patty
        dp[0][0] = 1;
        dp[0][1] = 1;
        for (int i = 1; i <= N; i++) {
            dp[i][0] = dp[i-1][0]*2 + 3;
            dp[i][1] = dp[i-1][1]*2 + 1;
        }
        bw.write(divide(N)+"");
        bw.flush();
        bw.close();
        br.close();
    }

    static long divide(int level) {
        if (level == 0) {return 1;}
        long cnt = 0; //해당 level 전체 패티
        //번
        X--;
        //n-1
        if (X >= dp[level-1][0]) {
            X -= dp[level-1][0];
            cnt += dp[level-1][1];
        }
        else if (X > 0) {
            cnt += divide(level - 1);
        }
        else return cnt;
        //패티
        if(X > 0) {
            X--;
            cnt++;
        }
        else return cnt;

        //n-1
        if (X >= dp[level-1][0]) {
            X -= dp[level-1][0];
            cnt += dp[level-1][1];
        }
        else if (X > 0) {
            cnt += divide(level - 1);
        }
        else return cnt;
        //번
        if (X > 0) X--;
        return cnt;
    }
}

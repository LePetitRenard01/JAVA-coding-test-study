import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static long[][] dp;
	static long cnt;
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		cnt = Long.parseLong(st.nextToken());
		
		dp = new long[n+1][2];
		dp[0][0] = 1;
		dp[0][1] = 1;
		for (int i = 1; i <= n; i++) {
			dp[i][0] = 2*dp[i-1][0] + 3;
			dp[i][1] = 2*dp[i-1][1] + 1;
		}
		bw.write(hambugi(n)+"");
		bw.flush();
	}
	
	private static long hambugi(int level) {
		long res = 0;
		if (cnt < 1) return res;
		if(level == 0) {
			cnt--;
			return 1;
		}
		
		cnt--;
		if (cnt < dp[level-1][0])
			res += hambugi(level-1);
		else {
			cnt -= dp[level-1][0];
			res += dp[level-1][1];
		}
		if (cnt > 0) {
			cnt--;
			res++;
		}
		if (cnt < dp[level-1][0])
			res += hambugi(level-1);
		else {
			cnt -= dp[level-1][0];
			res += dp[level-1][1];
		}
		if(cnt > 0)		cnt--;
		return res;
	}
}

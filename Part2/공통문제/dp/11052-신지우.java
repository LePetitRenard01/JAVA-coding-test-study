import java.io.*;
import java.util.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		int cost[] = new int[n+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			cost[i] = Integer.parseInt(st.nextToken());
		}
		
		int dp[] = new int[n+1];
		
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= i ; j++)
				dp[i] = Math.max(dp[i], dp[i-j] + cost[j]);
		}
		
		bw.write(dp[n]+"");
		bw.flush();
	}
}

import java.io.*;Add commentMore actions
import java.util.*;

public class BOJ_10211 {
    static int T, N;
    static int[] X, prefix;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());

            X = new int[N + 1];
            prefix = new int[N + 1];

            StringTokenizer st = new StringTokenizer(br.readLine());

            int max = Integer.MIN_VALUE;
            for (int j = 1; j <= N; j++) {
                X[j] = Integer.parseInt(st.nextToken());
                prefix[j] = prefix[j - 1] + X[j];

                for (int k = 0; k < j; k++) {
                    max = Math.max(max, prefix[j] - prefix[k]);
                }
            }
            sb.append(max).append("\n");
        }
        br.close();
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}

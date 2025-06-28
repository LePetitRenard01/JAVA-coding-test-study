import java.io.*;
import java.util.*;

public class BOJ_21921 {
    static int N, X, max, cnt;
    static int[] arr, prefix;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];
        prefix = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            prefix[i] = prefix[i - 1] + arr[i];
        }

        for (int i = X; i <= N; i++) {
            int sum = prefix[i] - prefix[i - X];

            if (sum > max) {
                max = sum;
                cnt = 1;
            } else if (sum == max) cnt++;
        }

        if (max == 0) sb.append("SAD");
        else sb.append(max).append("\n").append(cnt);

        br.close();
        bw.write(sb.toString());;
        bw.flush();
        bw.close();
    }
}

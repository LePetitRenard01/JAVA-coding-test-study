import java.io.*;
import java.util.*;

public class BOJ_19951 {
    static int N, M;
    static int[] arr, prefixSum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];
        prefixSum = new int[N + 2];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            prefixSum[a] += k;
            prefixSum[b + 1] -= k;
        }

        for (int i = 1; i <= N; i++) {
            prefixSum[i] += prefixSum[i - 1];
            sb.append(arr[i] + prefixSum[i]).append(" ");
        }
        System.out.println(sb);
    }
}

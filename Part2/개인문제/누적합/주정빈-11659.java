import java.util.*;
import java.io.*;

public class BOJ_11659 {
    static int N, M;
    static int[] arr, prefixSum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];
        prefixSum = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            prefixSum[i] = prefixSum[i - 1] + arr[i]; // 입력 시, 바로 누적합
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            System.out.println(prefixSum[m] - prefixSum[n - 1]);
        }
    }
}

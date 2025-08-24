import java.io.*;
import java.util.*;

public class BOJ_28353 {
    static int N, K, start, end, max;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N];
        start = 0;
        end = N - 1;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        while (start < end) {
            int sum = arr[start] + arr[end];
            if (sum <= K) {
                max++;
                start++;
            }
            end--;
        }
        sb.append(max);

        br.close();
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}

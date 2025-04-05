import java.io.*;
import java.util.*;

public class BOJ_2559 {
    static int N, K, sum;
    static int[] arr;
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        sum = 0;
        for (int i = 0; i < K; i++) {
            sum += arr[i];
        }
        // 최댓값 설정
        max = sum;

        // 슬라이딩 윈도우 - 연속된 K일 온도 합 갱신
        for (int i = K; i < N; i++) {
            sum += arr[i] - arr[i - K];
            max = Math.max(max, sum);
        }
        System.out.println(max);
    }
}

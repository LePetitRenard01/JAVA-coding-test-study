import java.io.*;
import java.util.StringTokenizer;

public class BOJ_19951 {
    static int N; // 연병장의 길이
    static int M; // 조교의 수
    static int[] arr; // 연병장 배열
    static int[] prefixSum; // 작업 - 누적합 배열
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 연병장의 길이 = N, 조교의 수 = M
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N+1];
        prefixSum = new int[N+1];

        // 연병장 입력 받기
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N+1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        // 작업 입력 받기
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            prefixSum[start] += weight;
            if (end + 1 <= N) {
                prefixSum[end + 1] -= weight;
            }

        }
        // 누적합
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            prefixSum[i] += prefixSum[i-1];
            sb.append((arr[i] + prefixSum[i])).append(" ");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}

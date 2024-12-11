import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int preSum[] = new int[n+1]; // 인덱스 +1,
        for (int i = 1; i <= n; i++) {
            // 첫 인덱스의 값은 이미 0이니까 i-1
            preSum[i] = preSum[i-1] + Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            sb.append(preSum[end] - preSum[start-1] + "\n");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}
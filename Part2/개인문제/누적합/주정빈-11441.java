import java.io.*;Add commentMore actions
import java.util.*;

public class BOJ_11441 {
    static int N, M;
    static int[] arr, prefix;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        prefix = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            prefix[i] = prefix[i - 1] + arr[i];
        }

        M = Integer.parseInt(br.readLine());
        for (int k = 1; k <= M; k++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            sb.append(prefix[j] - prefix[i- 1]).append("\n");
        }
        br.close();
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}

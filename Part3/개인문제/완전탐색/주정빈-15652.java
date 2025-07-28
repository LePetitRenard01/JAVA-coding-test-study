import java.io.*;
import java.util.*;

public class BOJ_15652 {
    static int N, M;
    static int[] arr;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];

        backTracking(0, 1);

        bw.flush();
        bw.close();
    }

    private static void backTracking(int depth, int start) throws IOException {
        StringBuilder sb = new StringBuilder();

        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            
            bw.write(sb.toString());
            return;
        }

        for (int i = start; i <= N; i++) {
            arr[depth] = i;
            backTracking(depth + 1, i);
        }
    }
}

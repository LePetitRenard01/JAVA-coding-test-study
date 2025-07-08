import java.io.*;
import java.util.*;

public class BOJ_17266 {
    static int N, M;
    static int[] x;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        x = new int[M];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            x[i] = Integer.parseInt(st.nextToken());
        }

        int low = 1;
        int high = N;
        int result = 0;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (isPossible(mid)) {
                result = mid;
                high = mid - 1;
            } else low = mid + 1;
        }
        sb.append(result);

        br.close();
        bw.write(sb.toString());;
        bw.flush();
        bw.close();
    }

    private static boolean isPossible(int height) {
        int last = 0;

        for (int i = 0; i < M; i++) {
            int left = x[i] - height;
            int right = x[i] + height;

            if (left > last) return false;
            else last = Math.max(last, right);
        }
        return N - last <= 0;
    }
}

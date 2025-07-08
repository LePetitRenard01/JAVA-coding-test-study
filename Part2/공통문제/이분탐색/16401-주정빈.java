import java.io.*;
import java.util.*;

public class BOJ_16401 {
    static int M, N;
    static int[] snacks;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        snacks = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            snacks[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(snacks);

        sb.append(binarySearch());

        br.close();
        bw.write(sb.toString());;
        bw.flush();
        bw.close();
    }

    private static int binarySearch() {
        int low = 1;
        int high = snacks[N - 1];
        int result = 0;

        while (low <= high) {
            int mid = (low + high) / 2;
            int cnt = 0;

            for (int i = 0; i < N; i++) {
                cnt += snacks[i] / mid;
            }

            if (cnt >= M) {
                result = mid;
                low = mid + 1;
            } else high = mid - 1;
        }
        return result;
    }
}

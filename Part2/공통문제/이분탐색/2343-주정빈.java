import java.io.*;
import java.util.*;

public class BOJ_2343 {
    static int N, M, low, high;
    static int[] lecture;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        lecture = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            lecture[i] = Integer.parseInt(st.nextToken());
            high += lecture[i];
            low = Math.max(low, lecture[i]);
        }
        sb.append(binarySearch());

        br.close();
        bw.write(sb.toString());;
        bw.flush();
        bw.close();
    }

    private static int binarySearch() {
        int result = 0;

        while (low <= high) {
            int mid = (low + high) / 2;
            int cnt = 1;
            int tmp = 0;

            for (int i = 0; i < N; i++) {
                if (tmp + lecture[i] > mid) {
                    cnt++;
                    tmp = lecture[i];
                } else tmp += lecture[i];
            }

            if (cnt <= M) {
                result = mid;
                high = mid - 1;
            } else low = mid + 1;
        }
        return result;
    }
}

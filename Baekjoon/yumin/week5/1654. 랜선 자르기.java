import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // 전역 변수
    static int[] lans;
    static int k;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        lans = new int[k];
        int max = 0;
        for (int i = 0; i < k; i++) {
            lans[i] = Integer.parseInt(br.readLine());
            if (lans[i] > max) max = lans[i];
        }

        // 이분 탐색
        System.out.println(findLength(1, max));
    }

    private static long findLength(long min, long max) {
        long length = 0;
        while (min <= max) {
            long mid = (max + min) / 2;

            int count = 0;
            for (int i = 0; i < k; i++) {
                count += lans[i] / (int)mid;
            }

            if (count >= n) {
                // 자른 조각이 더 많다면 너무 짧게 잘랐다는 의미
                // 자를 길이를 늘려야 함 -> mid를 min으로
                // + 자른 조각이 같다면 자를 최대 길이를 찾아야 함
                length = mid;
                min = mid+1;
            }


            else {
                // 자른 조각이 부족하면 너무 길게 잘랐다는 의미
                // 자를 길이를 줄여야 함-> mid를 max로
                max = mid-1;
            }
        }

        return length;
    }
}
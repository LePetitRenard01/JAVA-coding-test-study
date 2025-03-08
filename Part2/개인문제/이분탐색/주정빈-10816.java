import java.io.*;
import java.util.*;

public class BOJ_10816 {
    static int N, M;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());
            sb.append(upperBound(num) - lowerBound(num)).append(" "); // 숫자의 개수
        }
        System.out.println(sb);
    }
    // num보다 작은 숫자가 처음 등장하는 인덱스 찾음
    private static int lowerBound(int num) {
        int start = 0, end = N;
        while (start < end) {
            int mid = (start + end) / 2;
            if (arr[mid] >= num) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
    // num보다 큰 숫자가 처음 등장하는 인덱스 찾음
    private static int upperBound(int num) {
        int start = 0, end = N;
        while (start < end) {
            int mid = (start + end) / 2;
            if (arr[mid] > num) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}

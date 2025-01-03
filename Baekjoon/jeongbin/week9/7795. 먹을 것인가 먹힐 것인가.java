import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_7795 {
    static int T; // 테스트 케이스 개수
    static int N, M; // A의 수, B의 수
    static int[] A, B;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            A = new int[N];
            B = new int[M];

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[j] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                B[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(B);

            int result = 0;
            for (int id = 0; id < N; id++) {
                result += BinarySearch(A[id]);
            }
            System.out.println(result);
        }
    }
    public static int BinarySearch(int key) {
        int start = 0;
        int end = M - 1;
        int cnt = 0;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (B[mid] < key) {
                cnt = mid + 1; // mid + 1개의 원소가 key보다 작을 경우
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return cnt;
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2003 {
    static int N, M;
    static int start, end, cnt, sum;
    static int[] A;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        while (start <= N && end <= N) {
           if (sum == M) {
               cnt++;
           }
           if (sum > M) {
               sum -= A[start++];
           } else if (end < N) {
               sum += A[end++];
           } else {
               break;
           }
        }
        System.out.println(cnt);
    }
}

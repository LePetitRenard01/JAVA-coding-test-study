import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1806 {
    static int N; // 수열의 길이
    static int S; // 연속된 수 부분합 기준
    static int[] arr;
    static int start, end, sum;
    static int min = Integer.MAX_VALUE; // 최소 길이 (계산 전이므로 최댓값으로 설정)
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        while (start <= N && end <= N) {
            if (sum >= S) { // 부분합 중 합이 S 이상일 경우
                min = Math.min(min, end - start); // 최소 길이 갱신
                sum -= arr[start++]; // start 이동
            } else if (end < N){ // 부분합 중 합이 S 미만일 경우
                sum += arr[end++]; // end 이동
            } else break;
        }
        if (min == Integer.MAX_VALUE) {
            System.out.println(0);
        } else {
            System.out.println(min);
        }
    }
}

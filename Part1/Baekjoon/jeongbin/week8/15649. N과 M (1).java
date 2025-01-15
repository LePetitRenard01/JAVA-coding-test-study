import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15649 {
    static int N;
    static int M;
    static int[] arr;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        visited = new boolean[N];

        BackTracking(0);
    }
    public static void BackTracking(int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                System.out.println(arr[i]);
            }
            return;
        }
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = i + 1; // 선택한 숫자 저장
                BackTracking(depth + 1); // 재귀 -> 다음 깊이로 이동하여 숫자 선택
                visited[i] = false; // 원상 복구 -> 다른 조합 탐색
            }
        }
    }
}

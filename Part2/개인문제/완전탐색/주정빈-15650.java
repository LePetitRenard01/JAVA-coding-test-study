import java.io.*;
import java.util.*;

public class BOJ_15650 {
    static int N, M;
    static int[] arr;
    static boolean[] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        visited = new boolean[N];

        BackTracking(0, 0);
    }
    private static void BackTracking(int depth, int start) {
        StringBuilder sb = new StringBuilder();
        // 길이가 M일 경우 출력
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(arr[i]).append(" ");
            }
            System.out.println(sb);
            return;
        }
        for (int i = start; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[depth] = i + 1; // 선택한 숫자 저장
                BackTracking(depth + 1, i + 1); // 재귀 -> 다음 단계로 이동하여 숫자 선택
                visited[i] = false; // 원상 복구 -> 다른 조합 탐색 (백트래킹)
            }
        }
    }
}

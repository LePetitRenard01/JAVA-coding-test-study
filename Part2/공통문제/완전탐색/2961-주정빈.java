import java.io.*;
import java.util.*;

public class BOJ_2961 {
    static int N;
    static int[] S, B;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        S = new int[N];
        B = new int[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            S[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
        }
        BackTracking(0, 1, 0, 0);

        System.out.println(min);
    }
    private static void BackTracking(int depth, int s, int b, int cnt) {
        // 모든 재료 확인
        if (depth == N) {
            if (cnt > 0) { // 재료 최소 1개 이상 선택
                min = Math.min(min, Math.abs(s - b)); // 현재 최소값과 비교 후, 갱신
            }
            return;
        }
        // 현재 재료 선택
        BackTracking(depth + 1, s * S[depth], b + B[depth], cnt + 1);

        // 현재 재료 선택 X
        BackTracking(depth + 1, s, b, cnt);
    }
}

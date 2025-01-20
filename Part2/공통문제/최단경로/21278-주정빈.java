import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_21278 {
    static final int INF = 1000000;
    static int N, M, ans1, ans2, min; // 건물의 개수 (노드), 도로의 개수 (간선)
    static int[][] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dist = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j) continue;
                dist[i][j] = INF;
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            dist[A][B] = dist[B][A] = 1;
        }

        // 플로이드 워셜
        for (int k = 1; k <= N; k++) { // 경유지
            for (int i = 1; i <= N; i++) { // 출발지
                for (int j = 1; j <= N; j++) { // 도착지
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]); // 경유지를 거쳐가는 것이 더 빠르면 해당 경로로 업데이트
                }
            }
        }

        // 최적의 두 치킨집 선택
        ans1 = ans2 = min = INF;

        for (int i = 1; i <= N; i++) { // 첫 번째 치킨집
            for (int j = i + 1; j <= N; j++) { // 두 번째 치킨집
                int temp = 0;
                for (int k = 1; k <= N; k++) { // 일반 치킨집
                    temp += Math.min(dist[k][i], dist[k][j]) * 2; // k에서 i, j 중 더 가까운 치킨 집 거리 - 왕복
                }
                // 최소 거리 합 갱신
                if (temp < min) { // 현재 저장된 최소 거리 합인 min 보다 작을 경우
                    min = temp;
                    ans1 = i;
                    ans2 = j;
                }
            }
        }
        System.out.println(ans1 + " " + ans2 + " " + min);
    }
}

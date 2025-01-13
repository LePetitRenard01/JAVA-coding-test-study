import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_11724 {
    static int N, M, u, v, cnt; // 정점, 간선, 간선의 양 끝 점, 연결 요소 개수
    static int[][] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new int[N + 1][N + 1];
        visited = new boolean[N + 1];
        cnt = 0;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            graph[u][v] = 1;
            graph[v][u] = 1;
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                DFS(i);
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    private static void DFS (int start) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(start);
        visited[start] = true;

        for (int i = 1; i <= N; i++) {
            if (!visited[i] && graph[start][i] == 1) {
                DFS(i);
            }
        }
    }
}

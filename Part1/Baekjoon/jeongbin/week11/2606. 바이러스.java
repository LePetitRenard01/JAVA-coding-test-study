import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_2606 {
    static int N, M, cnt; // 컴퓨터의 수, 컴퓨터 쌍의 수, 바이러스 컴퓨터 수
    static int[][] graph;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        graph = new int[N+1][N+1];
        visited = new boolean[N+1];
        cnt = 0;

        for (int i = 0; i < M; i++) { // 간선의 개수만큼 탐색
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x][y] = 1;
            graph[y][x] = 1; // 양방향 그래프
        }
        DFS(1);
        System.out.println(cnt);
    }
    private static void DFS (int v) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(v); // 시작 노드
        visited[v] = true; // 시작 노드 방문 처리

        for (int i = 1; i <= N; i++) {
            if (graph[v][i] == 1 && !visited[i]) { // 인접 노드, 방문 X
                DFS(i);
                cnt++;
            }
        }
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;
public class BOJ_1260 {
    static int[][] graph;
    static boolean[] visited;
    static int N, M, V;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //정점의 개수
        M = Integer.parseInt(st.nextToken()); //간선의 개수
        V = Integer.parseInt(st.nextToken()); //탐색 시작 정점 번호

        graph = new int[N+1][N+1];
        visited = new boolean[N+1];

        //두 정점의 번호 입력
        for (int i = 0; i < M; i++) { //간선 개수만큼 탐색
            StringTokenizer sr = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(sr.nextToken());
            int y = Integer.parseInt(sr.nextToken());
            graph[x][y] = 1;
            graph[y][x] = 1;

        }
        visited = new boolean[N+1];
        DFS(V);

        System.out.println();

        visited = new boolean[N+1];
        BFS(V);
    }
    private static void DFS (int start) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(start); //시작 노드
        visited[start] = true; //시작 노드 방문 처리
        System.out.print(start + " ");

        for (int i = 0; i <= N; i++) {
            if (graph[start][i] == 1 && !visited[i]) {
                DFS(i);
            }
        }
    }

    private static void BFS (int start) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(start); //시작 노드
        visited[start] = true; //시작 노드 방문 처리

        while (!queue.isEmpty()) {
            start = queue.poll();
            System.out.print(start + " ");

            for (int i = 1; i <= N; i++) {
                if (graph[start][i] == 1 && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}

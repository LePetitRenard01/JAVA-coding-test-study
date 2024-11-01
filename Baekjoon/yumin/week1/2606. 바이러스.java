import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<Integer>[] graph;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());  // 컴퓨터 개수(노드)
        int l = Integer.parseInt(br.readLine());  // 연결된 선의 개수(간선)

        // 인접 배열(=그래프) 및 방문 배열 초기화
        graph = new ArrayList[n+1];
        visited = new int[n+1];

        for (int i = 0; i < n+1; i++) {
            graph[i] = new ArrayList<>();
        }

        // 그래프 연결
        for (int i = 0; i < l; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            // 양방향 고려
            graph[u].add(v);
            graph[v].add(u);
        }

        // 감염된 컴퓨터 체크
        int infectedCom = bfs(1);
        System.out.println(infectedCom);
    }

    private static int bfs(int start) {
        Queue<Integer> queue = new LinkedList<Integer>();
        visited[start] = 1; // 시작 노드 방문 표시
        queue.add(start);   // 시작 노드 큐에 넣기
        int count = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int neighbor : graph[current]) {
                if (visited[neighbor] == 0) {
                    visited[neighbor] = 1;
                    count++;
                    queue.add(neighbor);
                }
            }
        }

        return count;
    }
}
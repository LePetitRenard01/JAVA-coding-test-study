import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1753 {
    static final int INF = Integer.MAX_VALUE;
    static int V, E, K;
    static ArrayList<int[]>[] graph;
    static int[] dist;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken()); //노드의 수
        E = Integer.parseInt(st.nextToken()); //간선의 수
        K = Integer.parseInt(br.readLine()); //시작 정점의 번호

        //초기화
        graph = new ArrayList[V + 1];
        dist = new int[V + 1];
        visited = new boolean[V + 1];

        //미방문 지점은 매우 큰 값으로 초기화
        for (int i = 1; i <= V; i++){
            graph[i] = new ArrayList<>();
            dist[i] = INF;
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new int[]{v, w});
        }

        dijkstra(K);

        for (int i = 1; i <= V; i++) {
            if (dist[i] == INF) {
                System.out.println("INF");
            } else {
                System.out.println(dist[i]);
            }
        }
    }
    private static void dijkstra (int start) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        queue.add(new int[]{0, start});
        dist[start] = 0;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curDist = cur[0];
            int curNode = cur[1];

            if (curDist > dist[curNode]) continue;

            for (int[] edge : graph[curNode]) {
                int nNode = edge[0];
                int weight = edge[1];

                if (!visited[nNode] && dist[nNode] > curDist + weight) {
                    dist[nNode] = curDist + weight;
                    queue.add(new int[]{dist[nNode], nNode});
                }
            }
        }
    }
}

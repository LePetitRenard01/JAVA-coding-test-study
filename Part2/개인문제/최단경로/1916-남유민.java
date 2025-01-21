import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Node implements Comparable<Node> {
        int v;    // u -> v 중 v를 의미
        int cost;

        Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }

        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        // 0. 그래프 초기화
        List<Node>[] graph = new List[n+1];
        for (int i = 0; i <=n; i++) {
            graph[i] = new ArrayList<>();
        }

        // 1. 그래프 입력
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[u].add(new Node(v, cost));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken()); // 시작 정점
        int end = Integer.parseInt(st.nextToken());   // 끝 정점

        // 2. 다익스트라 알고리즘
        // 2-1. 거리 배열 초기화
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        // 2-2. 우선 순위 큐 사용
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0)); // 시작 정점 설정

        while (!pq.isEmpty()) {
            Node cur = pq.poll(); // 현재 정점 뽑기
            int currentNode = cur.v;

            // 2-3. 뽑은 정점의 비용이 저장된 최단 거리 비용보다 크면 건너뜀(= 최단 거리 확정)
            if (cur.cost > dist[currentNode]) continue;

            // 2-4. 뽑은 노드에 연결된 정점들 살피기 -> 거리 비용 갱신
            for (Node neighbor: graph[currentNode]) {
                int newCost = dist[currentNode] + neighbor.cost;
                if (newCost < dist[neighbor.v]) {
                    dist[neighbor.v] = newCost;
                    pq.add(new Node(neighbor.v, newCost));
                }
            }
        }

        System.out.println(dist[end]);
    }
}
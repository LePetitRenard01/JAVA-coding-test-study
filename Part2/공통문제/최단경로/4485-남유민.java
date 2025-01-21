import java.io. IOException;
import java.io. BufferedReader;
import java.io. InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int n;

    public static class Node implements Comparable<Node> {
        int x, y, cost;

        Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int testcase = 0;

        while(true) {
            testcase++;

            // 0. 무한루프 종료 조건
            n = Integer.parseInt(br.readLine());
            if (n == 0) break;

            // 1. 그래프 입력
            int[][] map = new int[n][n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 2. 다익스트라
            // 2-1. 거리배열 초기화
            int[] distance = new int[n*n];
            int idx = 0; // 거리배열 접근 인덱스 (2차원 -> 1차원)

            Arrays.fill(distance, Integer.MAX_VALUE);
            distance[0] = map[0][0]; // 시작점 설정 1

            PriorityQueue<Node> pq = new PriorityQueue<>();
            pq.add(new Node(0,0, map[0][0]));  // 시작점 설정 2

            while (!pq.isEmpty()) {
                // 2-2. 현재 노드 확인
                Node cur = pq.poll();
                int curX = cur.x;
                int curY = cur.y;
                idx = curX * n + curY;

                // 현재 노드의 비용이 저장된 거리 비용보다 크다면 넘어감 (= 최단 거리 확정)
                if (cur.cost > distance[idx]) continue;

                // 2-3. 현재 노드에서의 사방 탐색
                for (int i =0; i<4; i++) {
                    int nx = curX + dx[i];
                    int ny = curY + dy[i];

                    // 다음 노드들이 그래프 범위에 만족하고
                    if (0 <= nx && nx < n && 0 <= ny && ny < n) {
                        // 다음 노드까지의 최단 거리 비용을 갱신할수 있는지 체크
                        int newCost = distance[idx] + map[nx][ny];
                        if (newCost < distance[nx * n + ny]) {
                            distance[nx * n + ny] = newCost;
                            pq.add(new Node(nx, ny, newCost));
                        }
                    }
                }
            }

            // 3. 형식에 맞도록 출력
            System.out.println("Problem " + testcase+ ": "+ distance[n*n-1]);
        }

    }
}
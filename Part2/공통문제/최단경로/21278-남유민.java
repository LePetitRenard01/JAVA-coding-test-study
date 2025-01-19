import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int MAX_VALUE = 1_000_000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 1. 초기화
        int[][] graph = new int[n+1][n+1];
        for (int i=1; i<=n; i++) {
            for (int j = i; j<=n; j++) {     // 무방향 대칭 - 대각선만 봄
                if (i == j) graph[i][j] = 0; // 자기 자신 0
                else graph[j][i] = graph[i][j] = MAX_VALUE;
            }
        }

        // 2. 연결
        int a, b;
        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            graph[b][a] = graph[a][b] = 1;
        }

        // 3. 모든 노드의 최단 거리
        for (int k=1; k<=n; k++) {
            for (int i=1; i<=n; i++) {
                for (int j=i; j<=n; j++) {  // 무방향 대칭 - 대각선만 봄
                    graph[i][j] = Math.min(graph[i][j], graph[i][k]+graph[k][j]);
                    graph[j][i] = graph[i][j];
                }
            }
        }

        // 4. 치킨집 최소 거리 계산
        // 1,2           -> 1,3           -> 1,4           ->  ...
        // [3][1] [3][2]   [2][1] [2][3]    [2][1] [2][4]
        // [4][1] [4][2]   [4][1] [4][3]    [3][1] [3][4]
        // [5][1] [5][2]   [5][1] [5][3]    [5][1] [5][4]
        int x = Integer.MAX_VALUE;
        int firstStore = 0, secondStore = 0;
        for (int i=1; i<=n; i++) {
            for (int j=i+1; j<=n; j++) {
                int dist = 0;
                for (int k=1; k<=n; k++) {
                    if (k == i || k == j) continue;
//                    dist += Math.min(graph[k][i], graph[k][j]);
                    dist += Math.min(graph[i][k], graph[j][k]); // 두 치킨 집 중 작은 거리
                }

                if (dist < x) {
                    x = dist;
                    firstStore = i; secondStore = j;
                }
            }
        }
        System.out.println(firstStore+" "+secondStore+" "+(x*2));
    }
}
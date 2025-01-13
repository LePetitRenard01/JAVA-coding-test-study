import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int n;
    static char[][] painting;
    static boolean[][] visited1;
    static boolean[][] visited2;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int rgb, rb;
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

         // 1. 입력
         n = Integer.parseInt(br.readLine());
         painting = new char[n][n];
         visited1 = new boolean[n][n];  // 적록색맹이 아닌 사람의 방문 용도
         visited2 = new boolean[n][n];  // 적록색맹인 사람의 방문 용도
         for (int i = 0; i < n; i++) painting[i] = br.readLine().toCharArray();

         // 2. 그림 탐색
         for (int i = 0; i < n; i++) {
             for (int j = 0; j < n; j++) {
                 // 방문하지 않은 좌표라면
                 if (!visited1[i][j]) bfs1(i, j); // 적록색맹이 아닌 사람이 본 경우
                 if (!visited2[i][j]) bfs2(i, j); // 적록색맹인 사람이 본 경우
             }
         }

         // 3. 출력
        System.out.println(rgb+" "+rb);
    }

    // 적록색약이 아닌 사람의 경우
    static void bfs1(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});

        char firstColor = painting[x][y]; // 첫 컬러 체크
        visited1[x][y] = true; // 방문 체크

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i]; // 다음 x좌표
                int ny = cur[1] + dy[i]; // 다음 y좌표

                // 아직 방문 안한 다음 좌표가 범위에 있고
                // 같은 색깔이라면
                // 큐에 넣어 방문처리
                if (0<= nx && nx < n && 0 <= ny && ny < n
                        && !visited1[nx][ny] && firstColor==painting[nx][ny]) {
                    q.add(new int[]{nx, ny});
                    visited1[nx][ny] = true;
                }
            }
        }
        rgb++;
    }

    // 적록색약인 사람의 경우
    static void bfs2(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});

        // 첫 색이 블루인지 체크
        boolean isBule = (painting[x][y] == 'B' ? true : false);
        visited2[x][y] = true; // 방문 체크

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (isBule) { // 블루라면 블루만 큐에 담음
                for (int i = 0; i < 4; i++) {
                    int nx = cur[0] + dx[i]; // 다음 x좌표
                    int ny = cur[1] + dy[i]; // 다음 y좌표

                    if (0<= nx && nx < n && 0 <= ny && ny < n
                            && !visited2[nx][ny] && painting[nx][ny] == 'B') {
                        q.add(new int[]{nx, ny});
                        visited2[nx][ny] = true;
                    }
                }
            }
            else { // 레드 = 그린이므로 블루만 아니면 됨
                for (int i = 0; i < 4; i++) {
                    int nx = cur[0] + dx[i]; // 다음 x좌표
                    int ny = cur[1] + dy[i]; // 다음 y좌표

                    if (0<= nx && nx < n && 0 <= ny && ny < n
                            && !visited2[nx][ny] && painting[nx][ny] != 'B') {
                        q.add(new int[]{nx, ny});
                        visited2[nx][ny] = true;
                    }
                }
            }
        }
        rb++;
    }
}
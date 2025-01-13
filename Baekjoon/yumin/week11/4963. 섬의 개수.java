import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int w, h;
    static int[][] map;
    static boolean[][] visited;

    static int[] dx = {0, 0, 1, 1, 1, -1, -1, -1};
    static int[] dy = {1, -1, 1, 0, -1, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            // br.readLine() 무한 반복
            StringTokenizer st = new StringTokenizer(br.readLine());

            w = Integer.parseInt(st.nextToken()); // 너비
            h = Integer.parseInt(st.nextToken()); // 높이

            if (w == 0 && h == 0) break;    // 종료 조건

            // 지도 입력
            map = new int[h][w];
            visited = new boolean[h][w];
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int island = 0; // 섬 수 초기화
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    // 방문하지 않은 섬(=1)이라면
                    if (!visited[i][j]&&map[i][j] == 1) {
                        island++;
                        dfs(i, j);
                    }
                }
            }
            System.out.println(island);
        }
    }

    static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i]; // 다음 x좌표
            int ny = y + dy[i]; // 다음 y좌표

            // 좌표가 범위에 있고
            // 방문하지 않은 섬이 위치한 곳이라면
            // 한번 더 탐색
            if (0 <= nx && nx < h && 0 <= ny && ny < w
                    && !visited[nx][ny] && map[nx][ny] == 1) {
                dfs(nx, ny);
            }
        }
    }
}
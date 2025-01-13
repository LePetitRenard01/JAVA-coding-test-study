import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int[][] map;
    static boolean[][] visited;

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int house;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> houseList = new ArrayList<>();

        // 1. 입력
        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        // 2. 영역 탐색
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 집이 있는 곳(=1)을 방문하지 않았다면
                if (map[i][j] == 1 && !visited[i][j]) {
                    house = 0; // 집 수 초기화
                    dfs(i, j);
                    houseList.add(house);
                }
            }
        }

        // 3. 오름차순 정렬 후 출력
        Collections.sort(houseList);

        StringBuilder sb = new StringBuilder();
        sb.append(houseList.size()).append("\n");
        for (int house : houseList) sb.append(house).append("\n");
        System.out.println(sb);
    }

    static void dfs(int x, int y) {
        house++;
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i]; // 다음 x좌표
            int ny = y + dy[i]; // 다음 y좌표

            // 좌표가 범위에 있고
            // 방문하지 않은 아파트가 위치한 곳이라면
            // 한번 더 탐색
            if (0 <= nx && nx < n && 0 <= ny && ny < n
                    && !visited[nx][ny] && map[nx][ny] == 1) {
                dfs(nx, ny);
            }
        }
    }
}
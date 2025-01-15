import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;

public class BOJ_2178 {
    static int[][] maze;
    static boolean[][] visited;
    static int N, M;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        maze = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String sr = br.readLine();
            for (int j = 0; j < M; j++) {
                maze[i][j] = sr.charAt(j) -'0'; //아스키코드 변환
            }
        }
        bfs(0, 0);

        System.out.println(maze[N-1][M-1]);
    }
    private static void bfs (int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cx = current[0];
            int cy = current[1];
            for (int i = 0; i < 4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) { //범위 내에 있는지 확인
                    continue;
                }
                if (visited[nx][ny] || maze[nx][ny] == 0) { //방문 여부 및 막혔는지 확인
                    continue;
                }
                queue.add(new int[]{nx, ny});
                maze[nx][ny] = maze[cx][cy] + 1;
                visited[nx][ny] = true;
            }
        }
    }
}

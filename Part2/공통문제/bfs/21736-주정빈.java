import java.util.*;

public class BOJ_21736 {
    static int N, M, x, y, cnt;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 'I') {
                    x = i;
                    y = j;
                }
            }
        }
        BFS(x, y);

        if (cnt > 0) sb.append(cnt);
        else sb.append("TT");

        br.close();
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
    private static void BFS(int n, int m) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{n, m});
        visited[n][m] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cx = cur[0];
            int cy = cur[1];

            if (map[cx][cy] == 'P') cnt++;

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if (visited[nx][ny] || map[nx][ny] == 'X') continue;

                visited[nx][ny] = true;
                queue.add(new int[]{nx, ny});
            }
        }
    }
}

import java.io.*;
import java.util.*;

class Main {

    // 상하좌우 좌표 이동
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        char[][] matrix = new char[n][m];
        boolean[][] visited = new boolean[n][m];

        Queue<int[]> bfs = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                matrix[i][j] = line.charAt(j);
                // 도연이로 시작점 맞추기
                if (matrix[i][j] == 'I') {
                    bfs.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        // 입력으로부터 도연이가 들어있는 상태 (처음)
        int cnt = 0;
        while (!bfs.isEmpty()) {
            // 현재 뽑은 좌표
            int[] cur = bfs.poll();
            int x = cur[0];
            int y = cur[1];

            // 사람(P)이면 cnt 증가
            if (matrix[x][y] == 'P') cnt++;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 조건 하나 추가: matrix[nx][ny] != 'X'
                if (nx >= 0 && ny >= 0 && nx < n && ny < m && visited[nx][ny] == false
                        && matrix[nx][ny] != 'X') {
                    visited[nx][ny] = true;
                    bfs.offer(new int[] {nx, ny});
                }
            }
        }

        if (cnt == 0) bw.write("TT");
        else bw.write(cnt + "\n");
        bw.flush();
    }
}
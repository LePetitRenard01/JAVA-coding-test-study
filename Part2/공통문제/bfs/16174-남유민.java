import java.io.*;
import java.util.*;

class Main {

    static int[][] matrix;
    static boolean[][] visited;

    // 오른쪽, 아래 좌표 이동
    static int[] dx = {0, 1};
    static int[] dy = {1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

       int n = Integer.parseInt(br.readLine());
       matrix = new int[n][n];
       visited = new boolean[n][n];
       for (int i = 0; i < n; i++) {
           st = new StringTokenizer(br.readLine());
           for (int j = 0; j < n; j++) {
               matrix[i][j] = Integer.parseInt(st.nextToken());
           }
       }

       Queue<int[]> bfs = new LinkedList<>();
       bfs.offer(new int[]{0, 0});
       visited[0][0] = true;
       while (!bfs.isEmpty()) {
           int[] cur = bfs.poll();
           int x = cur[0];
           int y = cur[1];

           int jump = matrix[x][y]; // 점프할 수 있는 양

           if (jump == -1) {
               bw.write("HaruHaru");
               bw.flush();
               return;  // 종료
           }

           for (int i=0; i < 2; i++) {
               int nx = x + dx[i] * jump;
               int ny = y + dy[i] * jump;

               if (nx >= 0 && ny >= 0 && nx < n && ny < n && visited[nx][ny] == false) {
                   visited[nx][ny] = true;
                   bfs.offer(new int[] {nx, ny});
               }
           }
       }

        bw.write("Hing");
        bw.flush();
    }
}
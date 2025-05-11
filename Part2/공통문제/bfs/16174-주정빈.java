import java.io.*;
import java.util.*;

public class BOJ_16174 {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static boolean isReach = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        DFS(0, 0);

        if (isReach) sb.append("HaruHaru");
        else sb.append("Hing");

        br.close();
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
    private static void DFS(int x, int y) {
        if (x < 0 || x >= N || y < 0 || y >= N || visited[x][y]) return;

        if (x == N - 1 && y == N - 1) {
            isReach = true;
            return;
        }
        visited[x][y] = true;

        int jump = map[x][y];
        DFS(x + jump, y);
        DFS(x, y + jump);
    }
}

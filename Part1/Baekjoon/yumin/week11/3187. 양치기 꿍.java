import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int r, c;
    static char[][] board;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int totalSheep = 0, totalWolf = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 1. 입력
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        board = new char[r][c];
        for (int i = 0; i < r; i++) {
            board[i] = br.readLine().toCharArray();
        }

        // 2. 영역 탐색
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (board[i][j] != '#') {
                    bfs(i, j);
                }
            }
        }

        // 3. 출력
        System.out.println(totalSheep +" "+ totalWolf);
    }

    static void bfs(int x, int y) {
        int sheep = 0, wolf = 0;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});

        // 해당 좌표 확인하고 방문 처리('#'로 변경)
        if(board[x][y] == 'k') sheep++;
        else if (board[x][y] == 'v') wolf++;
        board[x][y] = '#';

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i]; // 다음 x좌표
                int ny = cur[1] + dy[i]; // 다음 y좌표
                // 다음 좌표가 범위에 들어가고
                // 방문하지 않았다면
                if (0 <= nx && nx < r && 0 <= ny && ny < c
                        && board[nx][ny] != '#') {
                    // 해당 좌표 확인하고
                    if (board[nx][ny] == 'k') sheep++;
                    else if (board[nx][ny] == 'v') wolf++;

                    // 큐에 넣어 방문 처리('#'로 변경)
                    q.add(new int[]{nx, ny});
                    board[nx][ny] = '#';
                }
            }
        }
        // 양과 늑대 수 비교
        if (sheep > wolf) totalSheep += sheep;
        else totalWolf += wolf;
    }
}
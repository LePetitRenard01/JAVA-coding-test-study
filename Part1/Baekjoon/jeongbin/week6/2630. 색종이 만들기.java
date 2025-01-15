import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2630 {
    static int N; // 전체 종이의 한 변의 길이 (2, 4, 8, 16, 32, 64, 128)
    static int white = 0;
    static int blue = 0;
    static int paper[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        paper = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        division(0, 0, N);
        System.out.println(white);
        System.out.println(blue);
    }

    private static void division(int x, int y, int size) {
        // 탐색 영역이 한가지 색으로 통일된 경우
        if (check(x, y, size)) {
            if (paper[x][y] == 0) {
                white++;
            } else {
                blue++;
            }
        } else {
            division(x, y, size / 2); // 1사분면
            division(x + size / 2, y, size / 2);
            division(x, y + size / 2, size / 2);
            division(x + size / 2, y + size / 2, size / 2);
        }
    }
    private static boolean check(int x, int y, int size) {
        int color = paper[x][y];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j <size; j++) {
                if (paper[x+i][y+j] != color) {
                    return false; // 다른 색 -> false
                }
            }
        }
        return true; // 모든 색 동일 -> true
    }
}

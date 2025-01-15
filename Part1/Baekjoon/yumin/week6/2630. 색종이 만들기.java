import java.io.*;
import java.util.StringTokenizer;

public class Main {
    // 전역변수 선언
    static int n;
    static int[][] paper;
    static int[] answer = new int[2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        paper = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // nxn 크기의 색종이 [0][0] 첫 조각부터 확인
        cutPaper(0, 0, n);

        System.out.println(answer[0]);
        System.out.println(answer[1]);
    }

    private static void cutPaper(int x, int y, int size) {
        if (isSameColor(x, y, size)) {
            answer[paper[x][y]]++;
            return;
        }

        // 새로운 크기의 색종이
        int newSize = size/2;

        cutPaper(x, y, newSize);
        cutPaper(x, y+newSize, newSize);
        cutPaper(x+newSize, y, newSize);
        cutPaper(x+newSize, y+newSize, newSize);
    }

    private static boolean isSameColor(int x, int y, int size) {
        int firstColor = paper[x][y];

        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (paper[i][j] != firstColor) return false;
            }
        }

        return true;
    }
}
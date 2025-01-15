import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] paper;
    static int[] answer = new int[3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        paper = new int[n][n];

        // 종이 입력 받기
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 종이 자르기
        cutPaper(0, 0, n);
        System.out.println(answer[0]);
        System.out.println(answer[1]);
        System.out.println(answer[2]);
    }

    private static void cutPaper(int x, int y, int n) {
        // 정사각형 체크
        if (isSquare(x, y, n)) {
            answer[paper[x][y]+1]++;
            return;
        }

        // 9등분
        int newSize = n/3;

        cutPaper(x, y, newSize);
        cutPaper(x, y+newSize, newSize);
        cutPaper(x, y+newSize*2, newSize);

        cutPaper(x+newSize, y, newSize);
        cutPaper(x+newSize, y+newSize, newSize);
        cutPaper(x+newSize, y+newSize*2, newSize);

        cutPaper(x+newSize*2, y, newSize);
        cutPaper(x+newSize*2, y+newSize, newSize);
        cutPaper(x+newSize*2, y+newSize*2, newSize);
    }

    private static boolean isSquare(int x, int y, int size) {
        int firstColor = paper[x][y];

        for (int i=0; i<size; i++) {
            for (int j=0; j<size; j++) {
                if (paper[x+i][y+j] != firstColor) return false;
            }
        }

        return true;
    }
}
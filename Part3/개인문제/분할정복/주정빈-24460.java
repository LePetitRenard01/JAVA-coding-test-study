import java.io.*;
import java.util.*;

public class BOJ_24460 {
    static int N;
    static int[][] num;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        num = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                num[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        sb.append(division(0, 0, N));

        br.close();
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static int division(int x, int y, int size) {
        if (size == 1) return num[x][y];

        int[] tmp = new int[4];
        tmp[0] = division(x, y, size / 2);
        tmp[1] = division(x + size / 2, y, size / 2);
        tmp[2] = division(x, y + size / 2, size / 2);
        tmp[3] = division(x + size / 2, y + size / 2, size / 2);

        Arrays.sort(tmp);
        return tmp[1];
    }
}

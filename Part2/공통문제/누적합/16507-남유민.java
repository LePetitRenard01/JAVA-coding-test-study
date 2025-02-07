import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        // 1. 그래프 입력(누적 합)
        int[][] preSum = new int[r + 1][c + 1];
        for (int i = 1; i <= r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= c; j++) {
                // preSum[i - 1][j]: 윗 칸
                // preSum[i][j - 1]: 왼쪽 칸
                // preSum[i - 1][j - 1]: 대각선
                preSum[i][j] = Integer.parseInt(st.nextToken()) + preSum[i - 1][j] + preSum[i][j - 1] - preSum[i - 1][j - 1];
            }
        }



        // 2. 부분 합
        int r1, c1, r2, c2, bright;
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            r1 = Integer.parseInt(st.nextToken());
            c1 = Integer.parseInt(st.nextToken());
            r2 = Integer.parseInt(st.nextToken());
            c2 = Integer.parseInt(st.nextToken());
            bright = preSum[r2][c2] - preSum[r1-1][c2] - preSum[r2][c1-1] + preSum[r1-1][c1-1];
            sb.append((bright/((r2-r1+1)*(c2-c1+1)))).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
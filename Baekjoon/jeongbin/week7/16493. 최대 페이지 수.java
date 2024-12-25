import java.io.*;
import java.util.StringTokenizer;

public class BOJ_16493 {
    static int N; // 남은 기간
    static int M; // 챕터의 수
    static int[] day; // 소요 일 수
    static int[] page; // 페이지 수
    static int[][] knapsack;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        day = new int[M+1];
        page = new int[M+1];
        knapsack = new int[M+1][N+1];

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            day[i] = Integer.parseInt(st.nextToken());
            page[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i <= M; i++) { // 각 챕터 순회
            for (int j = 1; j <= N; j++) { // 남은 기간 순회
                if (j >= day[i]) { // 남은 시간 충분
                    knapsack[i][j] = Math.max(knapsack[i-1][j], knapsack[i-1][j-day[i]]+page[i]);
                }
                else { // 남은 시간 부족
                    knapsack[i][j] = knapsack[i-1][j];
                }
            }
        }
        System.out.println(knapsack[M][N]);
    }
}

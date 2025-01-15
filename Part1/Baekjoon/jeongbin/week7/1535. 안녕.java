import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1535 {
    static int N; //사람의 수
    static int[] power; //잃는 체력
    static int[] joy; //최대 기쁨의 수
    static int[][] knapsack;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        power = new int[N+1];
        joy = new int[N+1];
        knapsack = new int[N+1][100];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            power[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i<= N; i++) {
            joy[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j < 100; j++) {
                if (power[i] > j) {
                    knapsack[i][j] = knapsack[i-1][j]; //체력이 부족하면 이전 값 사용
                }
                else {
                    knapsack[i][j] = Math.max(knapsack[i-1][j], knapsack[i-1][j-power[i]]+joy[i]);
                }
            }
        }
        bw.write(String.valueOf(knapsack[N][99])); // 문자열로 변환
        bw.flush();
        bw.close();
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1149 {
    static int N;
    static int[][] arr;
    static int[][] cost;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 집의 수

        arr = new int[N][3];
        cost = new int[N][3];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken()); // R
            arr[i][1] = Integer.parseInt(st.nextToken()); // G
            arr[i][2] = Integer.parseInt(st.nextToken()); // B
        }
        cost[0][0] = arr[0][0];
        cost[0][1] = arr[0][1];
        cost[0][2] = arr[0][2];

        for (int i = 1; i < N; i++) {
            cost[i][0] += arr[i][0] + Math.min(cost[i-1][1], cost[i-1][2]);
            cost[i][1] += arr[i][1] + Math.min(cost[i-1][2], cost[i-1][0]);
            cost[i][2] += arr[i][2] + Math.min(cost[i-1][0], cost[i-1][1]);
        }
        int result = Math.min(cost[N-1][0], Math.min(cost[N-1][1], cost[N-1][2]));

        System.out.println(result);
    }
}

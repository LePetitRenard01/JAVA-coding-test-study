import java.io.*;

public class BOJ_1058 {
    static int N, result;
    static int[][] dist;
    static int INF = 1000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        dist = new int[N][N];
        result = 0;

        for (int i = 0; i < N; i++) {
            char[] map = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                if (i == j) dist[i][j] = 0;
                else {
                    if (map[j] == 'Y') dist[i][j] = 1;
                    else dist[i][j] = INF;
                }
            }
        }

        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N ; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            int cnt = 0;
            for (int j = 0; j < N; j++) {
                if (i == j) continue;
                if (dist[i][j] <= 2) cnt++;
            }
            result = Math.max(result, cnt);
        }
        sb.append(result);

        br.close();
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}

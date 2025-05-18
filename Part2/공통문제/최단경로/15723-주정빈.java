import java.io.*;
import java.util.*;

public class BOJ_15723 {
    static int N, M;
    static boolean[][] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        dist = new boolean[26][26];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int start = st.nextToken().charAt(0) - 'a';
            st.nextToken();
            int end = st.nextToken().charAt(0) - 'a';

            dist[start][end] = true;
        }

        for (int k = 0; k < 26; k++) {
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < 26; j++) {
                    if (dist[i][k] && dist[k][j]) dist[i][j] = true;
                }
            }
        }

        M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int start = st.nextToken().charAt(0) - 'a';
            st.nextToken();
            int end = st.nextToken().charAt(0) - 'a';

            if (dist[start][end]) sb.append("T").append("\n");
            else sb.append("F").append("\n");
        }
        br.close();
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}

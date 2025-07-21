import java.io.*;
import java.util.*;

public class BOJ_1931 {
    static int N, end, cnt;
    static int[][] time;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        time = new int[N][0];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            time[i][0] = Integer.parseInt(st.nextToken());
            time[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(time, (o1, o2) ->
                o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1]
        );

        for (int i = 0; i < N; i++) {
            if (time[i][0] >= end) {
                end = time[i][1];
                cnt++;
            }
        }
        sb.append(cnt);

        br.close();
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}

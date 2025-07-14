import java.io.*;
import java.util.*;

public class BOJ_11582 {
    static int N, k;
    static int[] chicken;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        chicken = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            chicken[i] = Integer.parseInt(st.nextToken());
        }
        k = Integer.parseInt(br.readLine());

        int member = N / k;

        for (int i = 0; i < N; i += member) {
            Arrays.sort(chicken, i, i + member);
        }

        for (int i : chicken) {
            sb.append(i).append(" ");
        }
        br.close();
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}

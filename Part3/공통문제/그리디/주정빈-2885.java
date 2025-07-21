import java.io.*;

public class BOJ_2885 {
    static int K, N, cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        K = Integer.parseInt(br.readLine());
        N = 1;

        while (N < K) {
            N *= 2;
        }
        int size = N;

        while (K > 0) {
            if (size > K) {
                size /= 2;
                cnt++;
            } else K -= size;
        }

        sb.append(N).append(" ").append(cnt);

        br.close();
        bw.write(sb.toString());;
        bw.flush();
        bw.close();
    }
}

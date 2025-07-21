import java.io.*;

public class BOJ_1789 {
    static long S, N, sum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        S = Long.parseLong(br.readLine());
        N = 1;

        while (true) {
            if (sum + N > S) break;
            else {
                sum += N;
                N++;
            }
        }
        sb.append(N - 1);

        br.close();
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}

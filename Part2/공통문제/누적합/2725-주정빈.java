import java.io.*;

public class BOJ_2725 {
    static int C, N;
    static int[] arr, prefix;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        C = Integer.parseInt(br.readLine());
        arr = new int[1001];
        prefix = new int[1001];

        for (int i = 0; i < C; i++) {
            N = Integer.parseInt(br.readLine());
            arr[i] = N;
        }

        prefix[1] = 3;
        for (int i = 2; i < 1001; i++) {
            int cnt = 0;
            for (int j = 1; j < i; j++) {
                if (gcd(i, j) == 1) cnt++;
            }
            prefix[i] = prefix[i - 1] + cnt * 2;
        }

        for (int i = 0; i < C; i++) {
            sb.append(prefix[arr[i]]).append("\n");
        }
        br.close();
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
  
    private static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}

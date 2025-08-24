import java.io.*;
import java.util.*;

public class BOJ_22857 {
    static int N, K, start, end, result;
    static int[] S;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        S = new int[N];

        int odd = 0;
        int even = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            S[i] = Integer.parseInt(st.nextToken());
        }

        while (end < N) {
            // 현재 숫자 홀짝 여부 판단
            if (S[end] % 2 == 1) odd++;
            else even++;

            // 홀수 개수가 K보다 많아지면 start 이동
            while (odd > K) {
                if (S[start] % 2 == 1) odd--;
                else even--;
                start++;
            }

            result = Math.max(result, even);
            end++;
        }
        sb.append(result);

        br.close();
        bw.write(sb.toString());;
        bw.flush();
        bw.close();
    }
}

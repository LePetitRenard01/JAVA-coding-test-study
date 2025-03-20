import java.io.*;
import java.util.*;

public class BOJ_11399 {
    static int N;
    static int[] P;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        P = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            P[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(P);

        int sum = 0;
        int result = 0;

        for (int i = 0; i < N; i++) {
            sum += P[i];
            result += sum;
        }
        System.out.println(result);
    }
}

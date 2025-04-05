import java.io.*;
import java.util.*;

public class BOJ_11728 {
    static int N, M;
    static int start, end;
    static int[] A, B;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N];
        B = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        while (start < N && end < M) {
            if (A[start] <= B[end]) sb.append(A[start++]).append(" ");
            else sb.append(B[end++]).append(" ");
        }

        // 남은 배열 정리
        while (start < N) sb.append(A[start++]).append(" ");
        while (end < M) sb.append(B[end++]).append(" ");

        System.out.println(sb);
    }
}

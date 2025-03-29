import java.io.*;
import java.util.*;

public class BOJ_1476 {
    static int E, S, M, result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        E = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        result = 1;

        while ((result - E) % 15 != 0 || (result - S) % 28 != 0 || (result - M) % 19 != 0) {
            result++;
        }
        System.out.println(result);
    }
}

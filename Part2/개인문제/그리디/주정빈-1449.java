import java.io.*;
import java.util.*;

public class BOJ_1449 {
    static int N, L;
    static int[] location;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        location = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i ++) {
            location[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(location);

        int result = 1;
        double start = location[0] - 0.5;

        for (int i = 0; i < N; i++) {
            if (start + L < location[i]) {
                result++;
                start = location[i] - 0.5; // 갱신
            }
        }
        System.out.println(result);
    }
}

import java.io.*;

public class BOJ_1436 {
    static int N; // N번째 영화
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        int movie = 666;
        int cnt = 1;

        while (cnt != N) {
            movie++; // 667 ~ 1666 ...
            if (String.valueOf(movie).contains("666")) {
                cnt++;
            }
        }
        System.out.println(movie);
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1094 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int X = Integer.parseInt(br.readLine());
        int cnt = 0;

        while (X > 0) {
            if (X % 2 == 1) { // 가장 오른쪽 비트가 0인지 1인지 판단
                cnt++; 
            }
            X /= 2; // 한 비트를 오른쪽으로 이동
        }
        System.out.println(cnt);
    }
}

import java.io.*;

public class BOJ_1065 {
    static int N, cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        cnt = 0;

        if (N < 100) { // 두 자리 수 이하일 경우, 무조건 한수
            System.out.println(N);
            return;
        } else {
            cnt = 99; // 1 ~ 99 모두 한수 -> 99로 초기화
            for (int i = 100; i <= N; i++) {
                int a = i / 100; // 백의 자리
                int b = (i % 100) / 10; // 십의 자리
                int c = (i % 100) % 10; // 일의 자리

                if (a - b == b - c) cnt++; // 등차수열 확인
            }
        }
        System.out.println(cnt);
    }
}

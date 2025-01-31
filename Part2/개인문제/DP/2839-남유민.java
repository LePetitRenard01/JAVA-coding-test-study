import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int count = 0;

        while (n > 0) {
            if (n % 5 == 0) {
                count += n / 5;
                n = 0; // 모든 설탕을 배달
                break;
            }
            n -= 3; // 3kg 봉지 하나 사용
            count++;
        }

        // n이 0이 아니면 배달할 수 없는 경우
        if (n < 0) {
            System.out.println(-1);
        } else {
            System.out.println(count);
        }
    }
}
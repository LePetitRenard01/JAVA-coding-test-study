import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String input;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스 입력
        int tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            input = br.readLine(); // 예제 입력
            if (isFolded(input)) System.out.println("YES");
            else System.out.println("NO");
        }
    }

    static boolean isFolded(String input) {
        int len = input.length();
        if (len == 1) return true; // 길이가 1이면 비교 X

        int half = len / 2;
        // 중간을 기준으로 각 왼쪽, 오른쪽 씩 비교
        for (int i = 1; i < half + 1; i++) {
            if (input.charAt(half - i) == input.charAt(half + i)) return false;
        }

        // 0001111 인 경우도 있을 수 있으니, 분할 정복
        // input.substring(0, half): 왼쪽
        // input.substring(half + 1): 오른쪽
        return isFolded(input.substring(0, half)) && isFolded(input.substring(half + 1));

    }
}
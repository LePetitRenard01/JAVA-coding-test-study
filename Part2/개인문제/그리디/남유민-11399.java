import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();

        int ans = arr[0]; // 시작 숫자
        for (int i = 1; i < n; i++) {
            arr[i] += arr[i-1]; // 개인당 누적 시간
            ans += arr[i];      // 전체 누적 시간
        }

        System.out.println(ans);
    }
}
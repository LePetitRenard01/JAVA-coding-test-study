import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        // 배열 입력
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int end = 0;    // 끝 포인터
        int sum = 0;    // 특정 구간의 부분합
        int ans = Integer.MAX_VALUE; // 구간 길이 최소 비교 목적

        for (int start = 0; start < n; start++) {
            // 시작 포인터와 끝 포인터까지의 합
            while (sum < s && end < n) {
                sum += arr[end];
                end++;
            }

            // 부분합이 s 이상이면 구간 길이 계산
            // 최소 구간 길이 갱신
            if (sum >= s) {
                int len = end - start;
                ans = Math.min(ans, len);
            }

            // 시작 포인터 한칸 옮기기
            sum -= arr[start];
        }

        // 부분합이 s 이상인 구간이 없는 경우(= ans 값 그대로) 0 출력
        System.out.println(ans == Integer.MAX_VALUE ? 0 : ans);
    }
}
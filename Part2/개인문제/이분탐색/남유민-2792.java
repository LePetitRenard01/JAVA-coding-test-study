import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    static int[] arr;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new int[m];
        for (int i = 0; i < m; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        System.out.println(binarySearch(1, arr[m-1], n));
    }

    static int binarySearch(int s, int e, int n) {
        // mid: 학생이 최대로 가질 수 있는 보석 수
        // mid를 최소화하는 것이 목적
        int mid = 0;

        while (s <= e) {
            mid = (s + e) / 2;
            int sum = 0;

            for (int i = 0; i < arr.length; i++) {
                if (arr[i] % mid == 0) {
                    sum += arr[i] / mid;
                }
                else {
                    sum += arr[i] / mid + 1;
                }
            }


            if (sum <= n) {
                // 더 작은 범위에서 나눠서 sum 개수 늘려야 함
                // 더 작은 범위 -> mid 값은 작게 됨
                // mid를 최소화하고자 'sum == n' 조건도 여기 포함
                e = mid - 1;
            }
            else {
                // 더 큰 범위에서 나눠서 sum 개수 줄여야 함
                // 더 큰 범위 -> mid 값은 커짐
                s = mid + 1;
            }
        }
        return s;
    }
}
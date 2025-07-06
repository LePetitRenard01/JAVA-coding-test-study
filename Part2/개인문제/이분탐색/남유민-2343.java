import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st=new StringTokenizer(br.readLine());
        int sum = 0, min = Integer.MIN_VALUE; // 최대 길이의 강의
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
            min = Math.max(min, arr[i]);
        }

        int max = sum, mid;
        int b_cnt, b_sum, ans = 0;
        while (min <= max) {
            mid = min + (max - min) / 2;
            b_cnt = 1;
            b_sum = 0;
            for (int i = 0; i < n; i++) {
                if (b_sum + arr[i] <= mid) { // b_sum 값 업데이트 x
                    b_sum += arr[i];         // b_sum 값 업데이트
                } else {
                    b_cnt++;
                    b_sum = arr[i];
                }
            }

            // 용량을 더 키워야 함
            if (b_cnt > m) min = mid + 1;

            // 용량 줄이기 가능
            if (b_cnt <= m) {
                ans = mid; // mid 값 저장
                max = mid - 1;
            }
        }

        bw.write(ans+"\n");
        bw.flush();
    }
}
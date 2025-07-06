import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        int max = Integer.MIN_VALUE;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
        }


        int min = 1, ans = 0;
        while (min <= max) {
            int mid = (min + max)/2;

            int snk = 0;
            for (int i = 0; i < n; i++) {
                snk += arr[i] / mid;
            }

            // 과자 수 부족
            if (snk < m) max = mid-1;
                // 과자 수 넉넉
            else {
                ans = mid;
                min = mid+1;
            }
        }

        System.out.println(ans);
    }
}
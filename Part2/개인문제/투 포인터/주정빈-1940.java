import java.io.*;
import java.util.*;

public class BOJ_1940 {
    static int N, M;
    static int start, end, sum, cnt;
    static int[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        sum = 0;
        start = 0;
        end = N - 1;

        while (start < end) {
            sum = arr[start] + arr[end];

            if (sum > M) {
                end--;
            } else if (sum < M) {
                start++;
            } else {
                cnt++;
                start++;
                end--;
            }
        }
        bw.write(cnt + "");
        bw.flush();
        bw.close();
    }
}

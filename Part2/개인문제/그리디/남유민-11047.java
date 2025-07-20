import java.io.*;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        // 동전 가치 입력
        int[] a = new int[n+1];
        for (int i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }

        int coin = 0;
        // n > 0 : 동전 가치 입력된 인덱스 고려
        while (k > 0 && n > 0) {
            // 가장 큰 가치인 n번째 인덱스부터 살펴봄
            if (a[n] <= k) {
                coin += k/a[n];
                k -= a[n] * (k/a[n]); // 잔돈
            }
            n--; // 다음 가치의 인덱스
        }

        bw.write(coin + "");
        bw.flush();
    }
}
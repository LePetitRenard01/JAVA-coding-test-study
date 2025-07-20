import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int k = Integer.parseInt(br.readLine());

        // 최소 길이
        int  n = 1;
        while (n < k) n *= 2;
        sb.append(n);

        int cnt = 0;
        while (k > 0) {
            if (k < n) {
                n /= 2;
                cnt++;   // 자른 횟수
            }
            else k -= n; // 자른 길이 만큼 제거
        }

        sb.append(" ").append(cnt);
        bw.write(sb.toString());
        bw.flush();
    }
}
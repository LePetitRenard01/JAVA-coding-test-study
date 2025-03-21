import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int i = 0;
        while (true) {
            String input = br.readLine();
            if (input.equals("0 0 0")) break;

            StringTokenizer st = new StringTokenizer(input);

            int l = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            int ans = (v / p) * l;

            // v % p: 캠핑하고 남은 휴가 기간
            // v % p가 l 보다 큰 경우가 존재하므로 이에 대한 처리가 필요했음
            ans = (v % p) > l ? ans + l : ans + v % p;
            // ans += Math.min(l, v % p)

            System.out.println("Case " + (++i) + ": " + ans);
        }
    }
}
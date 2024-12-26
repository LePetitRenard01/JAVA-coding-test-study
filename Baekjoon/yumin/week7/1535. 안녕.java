import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] hp = new int[n+1];
        int[] joy = new int[n+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            hp[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            joy[i] = Integer.parseInt(st.nextToken());
        }

        // 내 남운 체력(열, j)까지
        // 사람(행, i)에게 인사를 함으로써 얻을 수 있는
        // 최대 기쁨 테이블
        int[][] maxJoy= new int[n+1][100];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= 99; j++) {
                if (hp[i] <= j) {
                    // 인사할 사람의 체력이 내 남은 체력(j)이하로 작아야 인사 가능
                    // 이전 사람(i-1) 또는 지금 사람(i)까지 인사했을 때의 기쁨 중 최대를 고름
                    maxJoy[i][j] = Math.max(maxJoy[i - 1][j], maxJoy[i - 1][j - hp[i]] + joy[i]);
                }
                else maxJoy[i][j] = maxJoy[i-1][j];
            }
        }

        System.out.println(maxJoy[n][99]);
    }
}
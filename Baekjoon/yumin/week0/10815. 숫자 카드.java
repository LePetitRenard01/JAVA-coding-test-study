import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. 상근이가 가진 카드 입력
        int n = Integer.parseInt(br.readLine());
        Set<Integer> cardSet = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            cardSet.add(Integer.parseInt(st.nextToken()));
        }

        // 2. 확인할 카드 입력
        int m = Integer.parseInt(br.readLine());
        int[] cardArr = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            cardArr[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            // 상근이가 가지는 카드에서 탐색, O(1)
            if (cardSet.contains(cardArr[i])) {
                sb.append(1).append(" ");
            }
            else {
                sb.append(0).append(" ");
            }
        }

        System.out.println(sb);
    }
}
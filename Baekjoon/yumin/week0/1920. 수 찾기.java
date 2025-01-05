import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 1. n과 그 수들 입력받기
        int n = Integer.parseInt(br.readLine());
        Set<Integer> arr = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }

        // 2. m과 그 수들 입력받기
        int m = Integer.parseInt(br.readLine());
        int[] arr2 = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < m; i++) {
            // 존재하면 1 출력, 존재 안하면 0 출력
            if (arr.contains(arr2[i])) {
                System.out.println(1);
            } else System.out.println(0);
        }
    }
}
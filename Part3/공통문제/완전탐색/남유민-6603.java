import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int k;
    static boolean[] visit;
    static int[] arr;
    static int[] S;

    private static void DFS(int start, int depth) {
        if (depth == 6) {
            for (int val : arr) {
                System.out.print(val + " ");
            }
            System.out.println();
            return;
        }

        // 1 2 3 4 5 6 7
        // DFS(0, 0)에서
        // i = 0, visit[0] = false > arr[0] = S[0] = 1, > DFS(0, 1)
        // 근데 아직 visit[0]은 true
        // i = 1, visit[1] = false > arr[1] = S[1] = 2, > DFS(1, 2)
        // visit[2] 빼고 다 true니까
        // i = 2,  visit[2] = false > arr[2] = 3 > DFS(2, 3)
        for (int i = start; i < k; i++) {
            if (!visit[i]) {
                visit[i] = true;
                arr[depth] = S[i];
                DFS(i, depth + 1);
                visit[i] = false;
            }
        }
        return;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true) {
            st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());

            if (k == 0) break;  // 종료 조건

            // 로또 번호 입력
            S = new int[k];
            visit = new boolean[k];

            for (int i = 0; i < k; i++) {
                S[i] = Integer.parseInt(st.nextToken());
            }

            arr = new int[6];

            DFS(0, 0);
            System.out.println();
        }
    }
}

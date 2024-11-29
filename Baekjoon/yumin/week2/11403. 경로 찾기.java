import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 정점 수 입력
        int n = Integer.parseInt(br.readLine());

        // 그래프 입력(인접 행렬)
        int[][] graph = new int[n][n];
        for (int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 플로이드- 워셜
        // [i][j]는 결국 [i][k] -> [k][j]
        for (int k=0; k<n; k++) {         // 경유
            for (int i=0; i<n; i++) {      // 시작
                for (int j=0; j<n; j++)  {  // 도착
                    if (graph[i][k] == 1 && graph[k][j] == 1) {
                        graph[i][j] = 1;
                    }
                }
            }
        }

        // 출력
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                sb.append(graph[i][j] + " ");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
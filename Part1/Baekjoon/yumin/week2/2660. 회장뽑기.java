import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int INF = 100_000_000;
        int n = Integer.parseInt(br.readLine());

        // 그래프 초기화
        int[][] graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i != j) graph[j][i] = graph[i][j] = INF;
            }
        }

        // 그래프 연결
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            if (i == -1 && j== -1) break;

            graph[i-1][j-1] = 1;
            graph[j-1][i-1] = 1;
        }

        // 회장 뽑기 (플로이드-워셜)
        for(int k=0;k<n;k++) {
            for (int i=0; i<n; i++) {
                for (int j=i+1; j<n; j++) {
                    graph[j][i] = graph[i][j] = Math.min(graph[i][k] + graph[k][j], graph[i][j]);
                }
            }
        }

        // 각 행의 최대값 찾기 + 최솟값 추출
        int[] row_score = new int[n];
        int min_score = INF;
        for (int i=0; i<n; i++) {
            int max_score = 0;
            for (int j=0; j<n; j++) {
                max_score = Math.max(max_score, graph[i][j]);
            }
            row_score[i] = max_score;
            min_score = Math.min(row_score[i], min_score);
        }


        StringBuilder sb1 = new StringBuilder();
        sb1.append(min_score).append(" ");

        int min_cnt = 0;
        StringBuilder sb2 = new StringBuilder();
        for (int i=0; i<n; i++) {
            if (row_score[i]==min_score) {
                min_cnt++;
                sb2.append(i+1).append(" ");
            }
        }
        sb1.append(min_cnt).append("\n");


        bw.write(sb1.toString());
        bw.write(sb2.toString());
        bw.flush();
    }
}
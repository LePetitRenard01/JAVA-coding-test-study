import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[][] matrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < n; j++) {
                if (input.charAt(j) == 'Y') {
                    matrix[i][j] = 1;
                } else {
                    matrix[i][j] = 0;
                }
            }
        }

        int max = Integer.MIN_VALUE;
        int res, visited;
        for (int i = 0; i < n; i++) {
            res = 0;    // i의 친구 개수 세기
            for (int j = 0; j < n; j++) {
                if (i == j) continue;   // 자기 자신 제외

                // 1. 직접 연결
                if (matrix[i][j] == 1) {
                    res++;
                }

                // 2. 간접 연결
                else {
                    visited = 0; // 친구 확인용 변수
                                 // 0: 친구 아님 -> 확인 해야 함, 1: 친구 -> 더이상 확인할 필요 없음
                    for (int k = 0; k < n; k++) {
                        if (i == k || j == k) continue; // 자기 자신 제외

                        if (matrix[i][k] == 1 && matrix[k][j] == 1 && visited == 0) {
                            res++;
                            visited = 1; // 친구
                        }
                    }
                }
            }
            max = Math.max(max, res);
        }

        bw.write(max + " ");
        bw.flush();
    }
}
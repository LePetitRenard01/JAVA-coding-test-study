import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 1. 연병장 입력
        int[] ground = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n ; i++) {
            ground[i] = Integer.parseInt(st.nextToken());
        }

        // 2. 조교 지시
        int[] command = new int[n+2]; // 파야 하는 양 표시
        int start, end, dig;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            dig = Integer.parseInt(st.nextToken());
            command[start] += dig;
            command[end + 1] -= dig; // 반대 부호 의미: 누적합 상쇄 용도
        }

        // 3. 누적합 -> 전체적인 변화량
        for (int i = 1; i <= n ; i++) {
            command[i] += command[i-1]; // 땅의 병화량(command[i] = command[i-1] + command[i])
            ground[i] += command[i];     // 최종 땅 높이(ground[i] = ground[i] + command[i])
            sb.append(ground[i]).append(" ");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
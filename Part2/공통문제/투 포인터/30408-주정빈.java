import java.io.*;
import java.util.*;

public class BOJ_30408 {
    static int N;
    static int start;
    static int[] S;
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        S = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            S[i] = Integer.parseInt(st.nextToken());
        }

        // 과일 개수를 세기 위해 HashMap 사용 (key = 과일 번호, value = 과일 등장 수)
        HashMap<Integer, Integer> map = new HashMap<>();

        // 투 포인터 - 슬라이드 윈도우
        for (int end = 0; end < N; end++) {
            map.put(S[end], map.getOrDefault(S[end], 0) + 1);

            while (map.size() > 2) {
                map.put(S[start], map.get(S[start]) - 1);

                // 과일 개수가 0일 경우 map 에서 삭제
                if (map.get(S[start]) == 0) map.remove(S[start]);

                start++;
            }
            max = Math.max(max, end - start + 1);
        }
        bw.write(max + "");
        bw.flush();
        bw.close();
    }
}

import java.io.*;
import java.util.*;

public class BOJ_1141 {
    static int N, result;
    static String[] word;
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        word = new String[N];

        for (int i = 0; i < N; i++) {
            word[i] = br.readLine();
        }
        // 정렬 필요 -> 긴 단어를 먼저 봐야 접두사 판별 가능
        Arrays.sort(word, (a, b) -> b.length() - a.length());

        for (int i = 0; i < N; i++) {
            boolean isPrefix = false;
            for (int j = 0; j < i; j++) {
                if (word[j].startsWith(word[i])){
                    isPrefix = true;
                    break;
                }
            }
            if (!isPrefix) result++;
        }
        sb.append(result);

        br.close();
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}

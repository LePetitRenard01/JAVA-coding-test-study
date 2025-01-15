import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_1620 {
    static int N, M; // 포켓몬의 개수, 맞춰야 하는 문제의 개수
    static String name, input; // 포켓몬 이름, 찾고자 하는 포켓몬
    static HashMap<Integer, String> hm1 = new HashMap<Integer,String>();
    static HashMap<String, Integer> hm2 = new HashMap<String, Integer>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            name = br.readLine();
            hm1.put(i + 1, name);
            hm2.put(name, i + 1);
        }
        for (int i = 0; i < M; i++) {
            input = br.readLine();
            if (input.matches("\\d+")) { // 숫자 입력
                int key = Integer.parseInt(input);
                sb.append(hm1.get(key)).append("\n");
            } else { // 포켓몬 이름 입력
                sb.append(hm2.get(input)).append("\n");
            }
        }
        System.out.println(sb);
    }
}

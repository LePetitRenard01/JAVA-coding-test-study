import java.io.*;
import java.util.*;

public class BOJ_12933 {
    static char[] input;
    static char[] duck = {'q', 'u', 'a', 'c', 'k'};
    static boolean[] visited;
    static int index, result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = br.readLine().toCharArray();
        visited = new boolean[input.length];
        index = 0;
        result = 0;

        // q로 시작 X or 배열 길이 != 5의 배수
        if (input[0] != 'q' || input.length % 5 != 0) {
            System.out.println(-1);
            return;
        }

        for (int i = 0; i < input.length; i++) {
            List<Character> chars = new ArrayList<>();

            for (int j = i; j < input.length; j++) {
                // 방문 X, quack가 순서대로 나올 경우
                if (!visited[j] && input[j] == duck[index]) {
                    index++;
                    chars.add(input[j]);
                    visited[j] = true;
                }
                // k까지 도달 -> 0으로 초기화
                if (index == 5) index = 0;
            }
            if (!chars.isEmpty()) {
                // k로 끝나지 않을 경우
                if (chars.get(chars.size() - 1) != 'k') {
                    System.out.println(-1);
                    return;
                }
                result++;
            }
        }
        System.out.println(result);
    }
}

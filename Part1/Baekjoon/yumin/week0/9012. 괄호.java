import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());    // 테스트 케이스 수

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            String input = br.readLine();
            // 괄호 문자열 체크
            if (isValidPS(input)) sb.append("YES\n");
            else sb.append("NO\n");
        }

        // 출력
        System.out.print(sb);
    }

    // 괄호 문자열 체크
    private static boolean isValidPS(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }

        return stack.isEmpty();
    }
}
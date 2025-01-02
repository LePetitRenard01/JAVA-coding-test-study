import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_9012 {
    static int T; // 입력 데이터의 수
    static String test; // 테스트 데이터
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            Stack<Character> stack = new Stack<>();
            test = br.readLine();
            boolean check = true; // '('가 있는지 체크

            for (int j = 0; j < test.length(); j++) {
                if (test.charAt(j) == '(') {
                    stack.push(test.charAt(j));
                } else if (stack.isEmpty()) { // '('가 없는 경우
                    check = false;
                    break;
                } else {
                    stack.pop();
                }
            }

            if (check && stack.isEmpty()) { // check = true, 스택 비어있을 경우
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}

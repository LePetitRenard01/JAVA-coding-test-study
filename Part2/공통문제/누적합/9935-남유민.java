import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String explosion = br.readLine();

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            stack.push(input.charAt(i));

            boolean isExplosion = true;
            // 폭발 문자열 길이 이상이라면,
            if (stack.size() >= explosion.length()) {
                // 폭발 문자열의 각 글자와 비교
                for (int j = 0; j < explosion.length(); j++) {
                    // stack.get(k) == explosion.charAt(k): 한 글자씩 비교
                    // stack.size() - explosion.length(): 스택 크키 - 폭발 문자열 길이. 즉, 비교 글자 시작 위치
                    if (stack.get(stack.size() - explosion.length() + j) != explosion.charAt(j)) {
                        isExplosion = false;
                        break;
                    }
                }

                // 폭발 문자열 대상이라면, 제거
                if (isExplosion) {
                    for (int j = 0; j < explosion.length(); j++) {
                        stack.pop();
                    }
                }
            }
        }

        StringBuilder popStr = new StringBuilder();
        if (stack.isEmpty()) System.out.println("FRULA");
        else {
            while (!stack.isEmpty()) {
                popStr.append(stack.pop());
            }
            System.out.println(popStr.reverse());
        }
    }
}
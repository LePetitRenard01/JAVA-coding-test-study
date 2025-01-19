import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 1. 입력과 동시에 연산자, 피연산자 분리
        String input = br.readLine();
        Queue<Character> operator = new LinkedList<>();
        Queue<Integer> operand = new LinkedList<>();
        StringBuilder num = new StringBuilder();
        StringBuilder result = new StringBuilder();
        boolean cFlag = false; // 변수 이름 수정

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            // 0~9의 숫자라면
            if (Character.isDigit(c)) {
                num.append(c);
            } else { // 기호라면
                operator.add(c);

                if (num.length() > 0) { // 숫자가 비어있지 않으면 큐에 추가
                    operand.add(Integer.parseInt(num.toString()));
                    num = new StringBuilder(); // 초기화
                }

                if (c == 'C') {
                    cFlag = true;
                }
            }
        }

        // C가 하나도 없는 경우
        if (!cFlag) {
            System.out.println("NO OUTPUT");
            return;
        }

        // 2. 계산 (int형 주의)
        long num1 = operand.poll();  // 연산자 왼쪽
        long num2 = 0;               // 연산자 오른쪽
        for (int i = 0; i < n; i++) {
            char c = operator.poll();
            if (c == 'S') {
                num2 = operand.isEmpty()? 0 : operand.poll();
                num1 = num1 - num2;
            } else if (c == 'M') {
                num2 = operand.isEmpty()? 1 : operand.poll();
                num1 = num1 * num2;
            } else if (c == 'U') {
                num2 = operand.isEmpty()? 0 : operand.poll();
                if (num1 < 0) {
                    num1 = (num1 * -1 / num2) * -1;
                } else {
                    num1 = num1 / num2;
                }
            } else if (c == 'P') {
                num2 = operand.isEmpty()? 0 : operand.poll();
                num1 = num1 + num2;
            } else if (c == 'C') {
                result.append(num1).append(" ");
            }
        }

        System.out.println(result.toString().trim());
    }
}
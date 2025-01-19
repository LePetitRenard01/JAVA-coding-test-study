import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_21737 {
    static int N, tmp, result;
    static String str;
    static char ch; // 이전 연산자 저장
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringBuilder answer = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        str = br.readLine();
        ch = ' ';
        tmp = 0;
        result = 0;

        for (int i = 0; i < str.length(); i++) {
            char curCh = str.charAt(i); // 현재 연산자

            if (Character.isDigit(curCh )) { // 숫자 저장
                sb.append(curCh);
            } else { // 연산
                if (sb.length() > 0) { // 비어있지 X -> 숫자 변환 후 연산 진행
                    tmp = Integer.parseInt(sb.toString());
                    sb.setLength(0);
                }
                if (ch == 'S') {
                    result -= tmp;
                } else if (ch == 'M') {
                    result *= tmp;
                } else if (ch == 'U') {
                    result /= tmp;
                } else if (ch == 'P') {
                    result += tmp;
                } else if (ch == ' ') {
                    result = tmp;
                }
                ch = curCh; // 연산자 갱신

                if (curCh == 'C') { // 연산자 = C일 경우
                    answer.append(result).append(" "); // 정답 배열에 결과 저장
                }
            }
        }
        if (answer.length() == 0) {
            System.out.println("NO OUTPUT");
        } else {
            System.out.println(answer);
        }
    }
}

import java.util.*;
import java.io.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();

        ArrayDeque<Integer> nums = new ArrayDeque<>(); // 숫자 덱
        ArrayDeque<Character> operations = new ArrayDeque<>(); // SMUPC 덱

        int num = 0;
        //파싱
        boolean numberExists = false;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isAlphabetic(s.charAt(i))) {
                if (numberExists) {
                    nums.addLast(num);
                    num = 0;
                }
                numberExists = false;
                operations.addLast(s.charAt(i));
            }
            else {
                num *= 10;
                num += s.charAt(i) - '0';
                numberExists = true;
            }
        }

        //계산
        int res = nums.pop();
        boolean isPrinted = false;
        while (!operations.isEmpty()) {
            char op = operations.pop();
            // C 출력
            if (op == 'C') {
                bw.write(res + " ");
                isPrinted = true;
                continue;
            }

            if (nums.isEmpty()) break;

            // 사칙연산
            int now = nums.pop();
            switch (op) {
                case 'S' :
                    res -= now;
                    break;
                case 'M':
                    res *= now;
                    break;
                case 'U' :
                    res /= now;
                    break;
                case 'P':
                    res += now;
                    break;
            }
        }

        if (!isPrinted) bw.write("NO OUTPUT");
        bw.flush();
    }
}

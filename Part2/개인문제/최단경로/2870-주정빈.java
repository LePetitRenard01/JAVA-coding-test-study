import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ_2870 {
    static int M;
    static String str;
    static char ch;
    static ArrayList<BigInteger> result = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                ch = str.charAt(j);
                if (Character.isDigit(ch)) { // 숫자
                    sb.append(ch);
                } else { // 문자
                    if (sb.length() > 0) {
                        result.add(new BigInteger(sb.toString())); // 결과 저장
                        sb = new StringBuilder();
                    }
                }
            }
            if (sb.length() > 0) { // 마지막이 숫자로 끝날 경우
                result.add(new BigInteger(sb.toString()));
                sb = new StringBuilder();
            }
        }
        Collections.sort(result);
        for (BigInteger num : result) {
            System.out.println(num);
        }
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] set;
    static int length;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String input = br.readLine();
            if (input == null || input.trim().isEmpty()) break;

            int n = Integer.parseInt(input);
            length = (int)Math.pow(3, n);

            // length 길이 만큼의 0으로 채워진 배열 생성
            set = new int[length];

            setCantor(0, length);
            printCantor();
        }
    }

    private static void setCantor(int start, int size) {
        // 종료 조건: 자른 길이가 1일 때
        // 길이가 1이면 해당 인덱스를 1로 바꿈
        if (size == 1) {
            set[start] = 1;
            return;
        }

        // 새 길이로 다시 칸토어 실시
        int newSize = size / 3;

        setCantor(start, newSize);
        setCantor(start + newSize*2, newSize);
    }

    // 1이면 -, 0이면 공백으로 이루어진 sb 출력
    private static void printCantor() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            if (set[i] == 1) sb.append("-");
            else sb.append(" ");
        }
        System.out.println(sb.toString());
    }
}
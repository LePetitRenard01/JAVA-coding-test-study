import java.io.*;
import java.util.*;

public class BOJ_2841 {
    static int N, P, result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        Stack<Integer>[] stacks = new Stack[7];
        for (int i = 1; i < 7; i++) {
            stacks[i] = new Stack<>();
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int lineNum = Integer.parseInt(st.nextToken());
            int fretNum = Integer.parseInt(st.nextToken());

            while (!stacks[lineNum].isEmpty() && stacks[lineNum].peek() > fretNum) {
                stacks[lineNum].pop();
                result++;
            }

            if (stacks[lineNum].isEmpty() || stacks[lineNum].peek() < fretNum) {
                stacks[lineNum].push(fretNum);
                result++;
            }
        }
        sb.append(result);

        br.close();
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}

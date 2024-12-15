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
//            System.out.println("n: " + n);

            length = (int)Math.pow(3, n);
            set = new int[length];
//            System.out.println("set length: " + length);

            setCantor(0, length);
            printCantor();
        }
    }

    private static void setCantor(int start, int size) {
//        System.out.println("start: "+start+", size: "+size);
        if (size == 1) {
            set[start] = 1;
            return;
        }

        int newSize = size / 3;

        setCantor(start, newSize);
        setCantor(start + newSize*2, newSize);
    }

    private static void printCantor() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            if (set[i] == 1) sb.append("-");
            else sb.append(" ");
        }
        System.out.println(sb.toString());
    }
}
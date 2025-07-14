import java.io.*;

public class BOJ_23304 {
    static String S;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        S = br.readLine();

        if (division(S)) sb.append("AKARAKA");
        else sb.append("IPSELENTI");

        br.close();
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static boolean division(String str) {
        if (str.length() <= 1) return true;

        int mid = str.length() / 2;

        for (int i = 0; i < mid; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) return false;
        }
        return division(str.substring(0, mid)) && division(str.substring((str.length() + 1) / 2));
    }
}

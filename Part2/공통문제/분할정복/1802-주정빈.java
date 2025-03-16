import java.io.*;

public class BOJ_1802 {
    static int T;
    public static void main(String[] args) throws IOException{
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String str = br.readLine();
            if (divideConquer(str)) System.out.println("YES");
            else System.out.println("NO");
        }
    }
    private static boolean divideConquer(String str) {
        // 길이 = 1 -> 종료
        if (str.length() == 1) return true;

        int mid = str.length() / 2;

        // 좌우 반전 확인 -> 같으면 false
        for (int i = 0; i < mid; i++) {
            if (str.charAt(i) == str.charAt(str.length() - 1 - i)) {
                return false;
            }
        }
        // 왼쪽, 오른쪽 부분 확인
        return divideConquer(str.substring(0, mid)) && divideConquer(str.substring(mid + 1));
    }
}

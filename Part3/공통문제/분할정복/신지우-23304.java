import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        String s = br.readLine();
        int l =  s.length();
        boolean flag = divide(s, 0, s.length()-1);

        bw.write(flag?"AKARAKA":"IPSELENTI");
        bw.flush();
        bw.close();
        br.close();
    }

    static boolean divide(String s, int start, int end) throws IOException {
        if(start == end) return true;
        for (int i = start; i <= (start+end)/2; i++) {
            if (s.charAt(i) != s.charAt(end-i)) {
                return false;
            }
        }

        int mid1, mid2=(start+end)/2+1;
        if((end-start)%2==0){
            mid1 = (start+end)/2-1;
        }
        else{
            mid1 = (start+end)/2;
        }
        return divide(s, start, mid1) & divide(s, mid2, end);
    }
}

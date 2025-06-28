import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
       String s = br.readLine();
       int n = Integer.parseInt(br.readLine());

       int[][] alphabet = new int[s.length()+1]['z'-'a'+1];

       alphabet[1][s.charAt(0) - 'a'] = 1;
       for (int i = 1 ; i < s.length(); i++) {
           for (int j = 0; j < 'z'-'a'+1 ; j++) {
               alphabet[i+1][j] = alphabet[i][j];
           }
           alphabet[i+1][s.charAt(i)-'a']++;
       }

       for (int i = 0 ; i < n ; i++){
           StringTokenizer st = new StringTokenizer(br.readLine());
           char c = st.nextToken().charAt(0);
           int l = Integer.parseInt(st.nextToken());
           int r = Integer.parseInt(st.nextToken());
           bw.write((alphabet[r+1][c-'a'] - alphabet[l][c-'a'])+"\n");
       }

       bw.flush();
       bw.close();
    }
}

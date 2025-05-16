import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int ALPHABET_SIZE = 26;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] matrix = new int[ALPHABET_SIZE][ALPHABET_SIZE];

        int start, end;
        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());

            start = st.nextToken().charAt(0) - 'a';
            st.nextToken();
            end = st.nextToken().charAt(0) - 'a';

            matrix[start][end] = 1;
        }

        for (int k = 0; k < ALPHABET_SIZE; k++){
            for (int i = 0; i < ALPHABET_SIZE; i++){
                for (int j = 0; j < ALPHABET_SIZE; j++){
                    if (matrix[i][k] == 1 && matrix[k][j] == 1){
                        matrix[i][j] = 1;
                    }
                }
            }
        }

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());

            start = st.nextToken().charAt(0) - 'a';
            st.nextToken();
            end = st.nextToken().charAt(0) - 'a';

            if (matrix[start][end] == 1) bw.append("T\n");
            else bw.append("F\n");
        }

        bw.flush();
    }
}
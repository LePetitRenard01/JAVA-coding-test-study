import java.io.*;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

      StringTokenizer st = new StringTokenizer(br.readLine());

      int n = Integer.parseInt(st.nextToken());
      int m = Integer.parseInt(st.nextToken());

      // 연병장 초기 높이
      int[] arr = new int[n+1];
      st = new StringTokenizer(br.readLine());
      for (int i = 1; i < n+1; i++) {
          arr[i] = Integer.parseInt(st.nextToken());
      }

      // 조교의 지시
      int[] prefix_sum = new int[n+2];
      for (int i=0; i < m; i++) {
          st = new StringTokenizer(br.readLine());
          int a = Integer.parseInt(st.nextToken());
          int b = Integer.parseInt(st.nextToken());
          int k = Integer.parseInt(st.nextToken());
          prefix_sum[a] += k;
          prefix_sum[b+1] += -k;
      }

      // 누적합
      for (int i=1; i <= n; i++) {
          prefix_sum[i] += prefix_sum[i-1];
      }

      // 연병장 변화 높이
      StringBuilder sb = new StringBuilder();
      for (int i=1; i <= n; i++) {
          sb.append(arr[i] + prefix_sum[i]).append(" ");
      }
      bw.write(sb.toString());
      bw.flush();
  }
}

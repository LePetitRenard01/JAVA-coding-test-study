import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int k = Integer.parseInt(br.readLine());
        int[] arr = new int[(int)Math.pow(2, k) - 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        bfs(arr);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    // 가운데 출력
    // 왼쪽 가운데 출력
    // 오른쪽 가운데 출력
    // 왼왼 -왼오 - 오왼 - 오오
    static void bfs(int[] arr) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, arr.length-1, 0});
        //0,1,2
        int exDepth = 0;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            //출력
            if (cur[2] == 0) {}
            else if (exDepth == cur[2]) { sb.append(" ");}
            else { sb.append("\n"); exDepth++; }
            sb.append(arr[(cur[0]+cur[1])/2]);

            if(cur[0] == cur[1]) continue;

            //왼오 넣기
            queue.add(new int[]{cur[0], (cur[0]+cur[1])/2 - 1, cur[2] + 1});
            queue.add(new int[]{(cur[0]+cur[1])/2 + 1, cur[1], cur[2] + 1});
        }
    }
}

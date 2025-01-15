import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1865 {
    static class Bus {
        int u;
        int v;
        int val;
        public Bus (int u, int v, int val) {
            this.u = u;
            this.v = v;
            this.val = val;
        }
    }
    static int TC, N, M, W;
    static int dist[];
    static ArrayList<Bus> bus = new ArrayList<>();
    static final int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        TC = Integer.parseInt(br.readLine());
        while (TC --> 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            dist = new int[N + 1];
            bus.clear();

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());
                bus.add(new Bus(S, E, T));
                bus.add(new Bus(E, S, T));
            }
            //웜홀에 대한 정보
            for (int i = 0; i < W; i++) {
                st = new StringTokenizer(br.readLine());
                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());

                bus.add(new Bus(S, E, -T));
            }
            //음수 사이클 존재 여부 확인
            boolean hasNegativeCycle = false;
            for (int i = 1; i <= N; i++) {
                if (bellmanFord(i)) {
                    hasNegativeCycle = true;
                    break;
                }
            }
            sb.append(hasNegativeCycle ? "YES" : "NO").append("\n");
        }
        System.out.print(sb);
    }
    private static boolean bellmanFord(int start) {
        Arrays.fill(dist, INF);
        dist[start] = 0;

        for (int i = 1; i <= N - 1; i++) {
            boolean updated = false;
            for (Bus bus : bus) {
                if (dist[bus.u] != INF && dist[bus.v] > dist[bus.u] + bus.val) {
                    dist[bus.v] = dist[bus.u] + bus.val;
                    updated = true;
                }
            }
            if (!updated) break;
        }
        for (Bus bus : bus) { //음수 사이클 존재 여부 확인
            if (dist[bus.u] != INF && dist[bus.v] > dist[bus.u] + bus.val) {
                return true;
            }
        }
        return false;
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_11000 {
    private static class Lecture implements Comparable<Lecture> {
        int start, end;

        public Lecture(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo (Lecture o) {
            if (this.start == o.start) { // 시작 시각이 동일할 시, 종료 시각 비교
                return this.end - o.end;
            }
            return this.start - o.start;
        }
    }
    static int N, S, E;
    static Lecture[] lectures;
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        lectures = new Lecture[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            S = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            lectures[i] = new Lecture(S, E);
        }
        Arrays.sort(lectures);

        pq.add(lectures[0].end); // 첫 강의의 종료 시각을 우선순위 큐에 추가

        for (int i = 1; i < N; i++) {
            if (pq.peek() <= lectures[i].start) { // 현재 가장 빠른 종료 시각 <= 배정 X 강의 시작 시각
                pq.poll(); // 강의실 재사용 가능
            }
            pq.add(lectures[i].end); // 새 강의실 추가
        }
        System.out.println(pq.size());
    }
}

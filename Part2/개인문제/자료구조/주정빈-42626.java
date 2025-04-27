import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int a : scoville) {
            pq.offer(a);
        }
        
        while (pq.peek() < K) {
            if (pq.size() < 2) return -1;
            
            int tmp1 = pq.poll();
            int tmp2 = pq.poll();
            int food = tmp1 + (tmp2 * 2);
            
            pq.offer(food);
            answer++;
        }
        return answer;
    }
}

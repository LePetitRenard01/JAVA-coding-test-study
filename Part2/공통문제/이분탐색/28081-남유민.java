import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static long[] xLengthList;
    static long[] yLengthList;
    static long k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long w = Long.parseLong(st.nextToken());
        long h = Long.parseLong(st.nextToken());
        k = Long.parseLong(st.nextToken());

        // 가로 방향 커팅 수
        int n = Integer.parseInt(br.readLine());
        yLengthList = new long[n + 1];
        st = new StringTokenizer(br.readLine());

        long  Last = 0;
        for (int i = 0; i < n; i++) {
            long  y = Long.parseLong(st.nextToken());
            yLengthList[i] = y - Last;
            Last = y;
        }
        yLengthList[n] = h - Last; // 마지막 길이 처리

        // 세로 방향 커팅 수
        int m = Integer.parseInt(br.readLine());
        xLengthList = new long[m + 1];
        st = new StringTokenizer(br.readLine());

        Last = 0;
        for (int i = 0; i < m; i++) {
            long  x = Integer.parseInt(st.nextToken());
            xLengthList[i] = x - Last;
            Last = x;
        }
        xLengthList[m] = w - Last; // 마지막 길이 처리

        Arrays.sort(xLengthList);  // 오름차순 정렬

        long cnt = 0; // 자료형 타입 주의 (int면 오답)
        for (int i = 0; i < n + 1; i++) {
            // xLengthList의 인덱스 범위: 0 ~ m
            cnt += (binarySearch(0, m, yLengthList[i])+1);

        }

        System.out.println(cnt);
    }

    // 이분탐색
    static int binarySearch(int start, int end, long y) {
        int result = -1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (xLengthList[mid] * y <= k) {
                start = mid + 1;
                result = mid; // 조건에 맞아야 업데이트
            }

            else {
                end = mid - 1;
            }
        }

        // 조건을 만족하는 최대 인덱스(mid) 반환
        return result;
    }
}
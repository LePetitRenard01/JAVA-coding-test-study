import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Set<String> words = new HashSet<>();

        for (int i = 0; i < n; i++) {
            words.add(br.readLine()); // 중복 단어 처리
        }

        // 정렬
        List<String> sortedWords = new ArrayList<>(words);
        sortedWords.sort(Comparator.comparingInt(String::length));

        // i = 0 : 제일 짧은 단어, 접두사
        // sortedWords.size() - 1 : 비교 횟수, remove()에 의해 점점 줄어짐
        for (int i = 0; i < sortedWords.size() - 1; i++) {
            // j = i + 1 : 비교는 접두사 단어 다음부터
            for (int j = i + 1; j < sortedWords.size(); j++) {
                // sortedWords(): 접두사 체크 메소드
                if (sortedWords.get(j).startsWith(sortedWords.get(i))) {
                    sortedWords.remove(i);
                    i = -1; // remove()로 리스트 갱신되므로 맨 앞 단어로 이동하기 위해
                    break;  // 해당 접두사 비교 종료
                }
            }
        }

        bw.write(sortedWords.size() + "\n");
        bw.flush();
    }
}
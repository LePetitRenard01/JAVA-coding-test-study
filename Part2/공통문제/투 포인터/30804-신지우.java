import java.util.*;
import java.io.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] tang;
    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        tang = new int[n];
        for (int i = 0; i < n; i++) tang[i] = Integer.parseInt(st.nextToken());

        HashMap<Integer ,Integer> fruits = new HashMap<>();

        int res = 0;
        int left = 0;
        for (int i = 0; i < n; i++) {
            fruits.put(tang[i], fruits.getOrDefault(tang[i], 0)+1);
            while(fruits.size()>2) {
                fruits.put(tang[left], fruits.get(tang[left])-1);
                if (fruits.get(tang[left])==0) fruits.remove(tang[left]);
                ++left;
            }

            int sum = 0;
            for (int key : fruits.keySet()) sum += fruits.get(key);
            res = Math.max(res, sum);
        }

        bw.write(res+"");

        bw.flush();
        bw.close();
        br.close();

    }

}

import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		long ground[] = new long[n];
		long diff[] = new long[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			ground[i] = Long.parseLong(st.nextToken());
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			//a에 더하고 b+1부터 빼면?
			diff[a-1] += k;
			if(b < n) diff[b] -= k;
		}
		
		long accumulated = 0;
		for (int i = 0; i < n; i++) {
			accumulated += diff[i];
			ground[i] += accumulated;
		}
		
		for (long g : ground)
			bw.write(g +" ");
		bw.flush();
		
	}

}

import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static String str;
	public static void main(String[] args) throws IOException {
	//- out - in - in -
	//- out - in - in - in 역전 (- out - out - in -)
	// 계속 반 잘라가면서 왼쪽과 오른쪽이 안 겹치는지 확인 xor인지 확인
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			str = br.readLine();
			if (str.length() == 1) {
				bw.write("YES\n");
				continue;
			}
			bw.write(divideConquer(str.length(), str.length()/2)?"YES\n":"NO\n");
		}
		bw.flush();
		bw.close();
	}
	
	private static boolean divideConquer(int length, int mid) {
		if (length == 3) {
			return str.charAt(mid-1) != str.charAt(mid+1);
		}
		
		return isValid(length, mid) && divideConquer(length/2, mid/2) && divideConquer(length/2, mid + length/2/2 + 1);
	}
	
	private static boolean isValid(int length, int mid) {
		for (int i = mid - length/2; i < mid; i++) {
			if (str.charAt(i) == str.charAt(mid+length/2-i))
				return false;
		}
		return true;
	}

}

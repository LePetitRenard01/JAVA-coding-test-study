import java.io.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws IOException {
		String str = br.readLine();
		String target = br.readLine();
		
		char[] stack = new char[str.length()];
		int idx = 0;
		int tick = 0;
		while (idx < str.length()) {
			stack[tick++] = str.charAt(idx++);
			if (tick < target.length()) continue;
			boolean flag = true;
			for (int i = 0; i < target.length(); i++) {
				if (stack[tick - target.length() + i] != target.charAt(i)) {
					flag = false;
					break;
				}
			}
			
			if (flag)
				tick -= target.length();
		}
		
		StringBuilder res = new StringBuilder();
		for (int i = 0; i < tick ; i++)
			res.append(stack[i]);
		String result = String.valueOf(res);
		if (result.equals("")) bw.write("FRULA");
		else bw.write(String.valueOf(res));
		
		bw.flush();
	}
}

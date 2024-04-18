import java.util.*;
import java.io.*;
public class ArrMod {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt();
		int[] arr = new int[N];
		for(int i = 0; i<N; i++) {
			arr[i] = readInt();
		}
		int pre = arr[0];
		long total = 0;
		for(int i = 1; i<N; i++) {
			if(pre>=arr[i]) {
				total+=pre-arr[i]+1;
				arr[i]+=pre-arr[i]+1;
			}
			pre = arr[i];
		}
		System.out.println(total);
	}
	static String next () throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine().trim());
		return st.nextToken();
	}
	static long readLong () throws IOException {
		return Long.parseLong(next());
	}
	static int readInt () throws IOException {
		return Integer.parseInt(next());
	}
	static double readDouble () throws IOException {
		return Double.parseDouble(next());
	}
	static char readCharacter () throws IOException {
		return next().charAt(0);
	}
	static String readLine () throws IOException {
		return br.readLine().trim();
	}
}
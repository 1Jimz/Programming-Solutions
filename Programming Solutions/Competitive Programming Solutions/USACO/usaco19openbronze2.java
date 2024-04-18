import java.util.*;
import java.io.*;
public class MilkFactory {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException{
		int N = readInt();
		List<Integer>[] tree = new ArrayList[N+1];
		for(int i = 1; i<=N; i++) tree[i]=new ArrayList<Integer>();
		for(int i = 1; i<N; i++){
			int a = readInt(), b = readInt();
			tree[b].add(a);
		}
		
		for(int i = 1; i<=N; i++) {
		int unique = 0;
		Set<Integer> convo = new HashSet<Integer>();
		convo.add(i);
		boolean[] valid = new boolean[N+1];
		while(!convo.isEmpty()) {
			List<Integer> current = new ArrayList<Integer>(convo);
			convo.clear();
			for(int n : current) {
				if(!valid[n]) {
					valid[n]=true;
					unique++;
					for(int add : tree[n]) convo.add(add);
				}
				if(unique==N) {
					System.out.println(i);
					return;
				}
			}
		}
		}
		System.out.println("-1");
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
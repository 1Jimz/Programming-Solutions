import java.util.*;
import java.io.*;
public class SchoolTraversal {
	static class des {
		int n, w;
		public des(int n, int w) { 
			this.n=n; 
			this.w=w; 
		}
	}
	static void dfs(int u, int p) {
		depth[u]=depth[p]+1;
		ances[0][u]=p;
		for(int i = 1; i<ances.length; i++)ances[i][u]=ances[i-1][ances[i-1][u]];
		for(des e: adj[u]) {
			if(e.n==p)continue;
			away[e.n]=away[u]+e.w; 
			dfs(e.n, u);
		}
	}
	static long distance(int u, int v) {
		int oriu = u, oriv = v;
		if(depth[u]<depth[v]) {
			u = oriv;
			v = oriu; 
		}
		for(int k = ances.length-1; k>=0; k--)if(depth[ances[k][u]]>=depth[v])u=ances[k][u];
		if(u==v)return away[oriu]+away[oriv]-2*away[u];
		for(int k = ances.length-1; k>=0; k--) {
			if(ances[k][u]!=ances[k][v]) { 
				u = ances[k][u]; 
				v = ances[k][v]; 
			}
		}
		return away[oriu]+away[oriv]-2*away[ances[0][u]];
	}
	static int bitdex(int n) {return(int)(Math.log(n)/Math.log(2));}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int ances[][];
	static long depth[],away[]; 
	static List<des> adj[];
	public static void main(String[] args) throws IOException{
		int N = readInt();
		depth = new long[N+1];
		away = new long[N+1];
		adj = new ArrayList[N+1];
		ances = new int[bitdex(N)+1][N+1];
		for(int i = 1; i<=N; i++)adj[i] = new ArrayList<des>();
		for(int i = 1; i<N; i++) {
			int u = readInt()+1, v = readInt()+1, w = readInt();
			adj[u].add(new des(v, w));
			adj[v].add(new des(u, w));
		}
		dfs(1, 0);
		int Q = readInt();
		for(int i = 0; i<Q; i++)System.out.println(distance(readInt()+1,readInt()+1));
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
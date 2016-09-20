import java.io.*;
import java.util.*;


public class CAM5 {
	
	private ArrayList[] adj;
	private int noOfPeers;
	private boolean visited[];
	private int nodeDepth[];
	
	public CAM5(int peers){
		noOfPeers = peers;
		adj = new ArrayList[noOfPeers];
		for(int i =0;i<noOfPeers;i++){
			adj[i] = new ArrayList();
		}
	}
	
	public void addEdge(int v, int w){
		adj[v].add(w);
		adj[w].add(v);
	}
	
	private void dfs(int v, int parent, int depth){
		visited[v] = true;
		nodeDepth[v] = depth;
		Iterator<Integer> it = adj[v].iterator();
		Integer i;
		while(it.hasNext()){
			i = it.next();
			if(!visited[i]){
				dfs(i,v,depth+1);
			}
		}
	}
	
	public int components(){
		visited = new boolean[noOfPeers];
		nodeDepth = new int[noOfPeers];
		int count = 0;
		for(int i=0;i<noOfPeers;i++){
			visited[i] = false;
		}
		for(int j=0;j<noOfPeers;j++){
			if(!visited[j]){
				dfs(j,-1,0);
				count++;
			}
		}
		return count;
	}
	
	public static void main(String[] args){
		InputReader reader = new InputReader(System.in);
		PrintWriter writer = new PrintWriter(System.out);
		int t = reader.nextInt();
		for(int i=0;i<t;i++){
			int peers = reader.nextInt();
			int e = reader.nextInt();
			CAM5 cam = new CAM5(peers);
			for(int j=0;j<e;j++){
				cam.addEdge(reader.nextInt(), reader.nextInt());
			}
			writer.println(cam.components());
		}
		writer.close();
	}
	
	static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;
 
        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }
 
        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }
 
        public int nextInt() {
            return Integer.parseInt(next());
        }
 
        public long nextLong() {
        	return Long.parseLong(next());
        }
 
    }
}

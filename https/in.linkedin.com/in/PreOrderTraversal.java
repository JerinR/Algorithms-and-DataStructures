import java.io.*;
import java.util.*;



public class PreOrderTraversal {
	
	private int nodes;
	private ArrayList<Integer> node;
	private Map<Integer, ArrayList<Integer>> adj;
	private Map<Integer, Boolean> visited;
	
	public PreOrderTraversal(int nodes){
		this.nodes = nodes;
		adj = new HashMap<Integer, ArrayList<Integer>>();
		node = new ArrayList<Integer>();
	}
	
	public void addEdge(int u,int v){
		
		if(adj.get(v) == null){
			adj.put(v, new ArrayList<Integer>());
		}
		adj.get(v).add(u);
		if(adj.get(u) == null){
			adj.put(u, new ArrayList<Integer>());
		}
		adj.get(u).add(v);
		
		if(!node.contains(u))
			node.add(u);
		if(!node.contains(v))
			node.add(v);
	}

	public void dfs(int v, int parent){
		visited.put(v, true);
		System.out.println(v);
		
		Iterator it = adj.get(v).iterator();
		Integer i;
		while(it.hasNext()){
			i = (Integer) it.next();
			if(!visited.get(i)){
				dfs(i,v);
			}
		}
	}
	public void callDFS(){
		/*setting all the nodes in visited[] as false*/
		visited = new HashMap<Integer, Boolean>();
		
		int max = 0;
		for(int i : node){
			visited.put(i, false);
		}
		for(int j : node){
			if(!visited.get(j))
				dfs(j,-1);
		}
		
	}
	
	public static void main(String[] args){
		InputReader reader = new InputReader(System.in);
		PrintWriter writer = new PrintWriter(System.out);
		
		int n = reader.nextInt();
		PreOrderTraversal path = new PreOrderTraversal(n);
		for(int i=0;i<n-1;i++){
			path.addEdge(reader.nextInt(), reader.nextInt());
		}
		path.callDFS();
	}
	
	public static class InputReader{
		private BufferedReader reader;
		private StringTokenizer tokens;
		
		public InputReader(InputStream stream) {
			// TODO Auto-generated constructor stub
			reader = new BufferedReader(new InputStreamReader(stream), 67854);
			tokens = null;
		}
		
		public String next(){
			while(tokens == null || !tokens.hasMoreTokens()){
				try {
					tokens = new StringTokenizer(reader.readLine());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					throw new RuntimeException(e);
				}
			}
			return tokens.nextToken();
		}
		
		public int nextInt(){
			return Integer.parseInt(next());
		}
		
		public long nextLong(){
			return Long.parseLong(next());
		}
	}

}

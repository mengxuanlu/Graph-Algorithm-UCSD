import java.util.ArrayList;
import java.util.Scanner;

public class Reachability {
	private static boolean[] visited;
    private static int reach(ArrayList<Integer>[] adj, int x, int y) {
        //write your code here
    	dfs(adj, x);
    	if (visited[y]) return 1;
    	else 			return 0;
    }
    
    private static void dfs(ArrayList<Integer>[] adj, int t) {
    	visited[t] = true;
    	for (int j : adj[t]) {
    		if (!visited[j]) {
    			dfs(adj, j);
    		}
    	}
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        visited = new boolean[n];
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int x, y;
            x = scanner.nextInt();
            y = scanner.nextInt();
            adj[x - 1].add(y - 1);
            adj[y - 1].add(x - 1);
        }
        int x = scanner.nextInt() - 1;
        int y = scanner.nextInt() - 1;
        System.out.println(reach(adj, x, y));
        
    }
}


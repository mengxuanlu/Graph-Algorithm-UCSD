import java.util.ArrayList;
import java.util.Scanner;

public class ConnectedComponents {
	private static boolean[] visited;
	private static int[] ccNum;
	private static int result = 0;
    private static int numberOfComponents(ArrayList<Integer>[] adj) {
    	
    	for (int i = 0; i< adj.length; i++) {
    		if (!visited[i]) {
    			explore(adj, i);
    			result = result + 1;
    		}
    		
    	}
       
        return result;
    }
    
    private static void explore(ArrayList<Integer>[] adj, int v) {
    	visited[v] = true;
    	ccNum[v] = result;
    	for (int j = 0; j < adj[v].size(); j++) {
    		int w = adj[v].get(j);
    		if (!visited[w]) {
    			explore(adj, w);
    		}
    	}
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        visited = new boolean[n];
        ccNum = new int[n];
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
        
        System.out.println(numberOfComponents(adj));
    }
}


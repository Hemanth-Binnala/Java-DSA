// Given an undirected connected graph with V vertices numbered from 0 to V-1,
// the task is to implement both Depth First Search (DFS) and Breadth First Search (BFS) traversals starting 
// from the 0th vertex. The graph is represented using an adjacency list where adj[i] 
// contains a list of vertices connected to vertex i. Visit nodes in the order they appear in the adjacency list.

// Input: V = 5, adj = [[2, 3, 1], [0], [0, 4], [0], [2]]

// Output:[0, 2, 4, 3, 1], [0, 2, 3, 1, 4]

// Explanation:

// DFS: Start from vertex 0. Visit vertex 2, then vertex 4, backtrack to vertex 0, then visit vertex 3, and finally vertex 1. The traversal is 0 → 2 → 4 → 3 → 1.

// BFS: Start from vertex 0. Visit vertices 2, 3, and 1 (in the order they appear in the adjacency list). Then, visit vertex 4 from vertex 2. The traversal is 0 → 2 → 3 → 1 → 4.

// Input: V = 4, adj = [[1, 3], [2, 0], [1], [0]]

// Output: [0, 1, 2, 3], [0, 1, 3, 2]

// Explanation:

// DFS: Start from vertex 0. Visit vertex 1, then vertex 2, backtrack to vertex 0, then visit vertex 3. The traversal is 0 → 1 → 2 → 3.

// BFS: Start from vertex 0. Visit vertices 1 and 3, then visit vertex 2 from vertex 1. The traversal is 0 → 1 → 3 → 2.
package Graphs;
import java.util.*;

class Solution {

    public static void dfs(int node, boolean[] visited, List<Integer>[] adj, ArrayList<Integer> ls) {
        visited[node] = true;
        ls.add(node);

        for (Integer it : adj[node]) {
            if (!visited[it]) {
                dfs(it, visited, adj, ls);
            }
        }
    }

    public List<Integer> dfsOfGraph(int V, List<Integer>[] adj) {
        boolean[] visited = new boolean[V];
        ArrayList<Integer> ls = new ArrayList<>();
        dfs(0, visited, adj, ls);
        return ls;
    }

    public List<Integer> bfsOfGraph(int V, List<Integer>[] adj) {
        boolean[] visited = new boolean[V];
        ArrayList<Integer> bfs = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();

        q.add(0);
        visited[0] = true;

        while (!q.isEmpty()) {
            int node = q.poll();
            bfs.add(node);

            for (Integer it : adj[node]) {
                if (!visited[it]) {
                    visited[it] = true;
                    q.add(it);
                }
            }
        }

        return bfs;
    }
}

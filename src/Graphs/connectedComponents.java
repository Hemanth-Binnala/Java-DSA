package Graphs;

import java.util.*;
// Given a undirected Graph consisting of V vertices numbered from 0 to V-1 and E edges.
//  The ith edge is represented by [ai,bi], denoting a edge between vertex ai and bi. 
//  We say two vertices u and v belong to a same component if there is a path from u to v or v to u. 
//  Find the number of connected components in the graph.

// A connected component is a subgraph of a graph in which there exists a path between any two vertices, 
// and no vertex of the subgraph shares an edge with a vertex outside of the subgraph.

// Input: V=4, edges=[[0,1],[1,2]]

// Output: 2

// Explanation: Vertices {0,1,2} forms the first component and vertex 3 forms the second component.

// Input: V = 7, edges = [[0, 1], [1, 2], [2, 3], [4, 5]]

// Output: 3

// Explanation:

// The edges [0, 1], [1, 2], [2, 3] form a connected component with vertices {0, 1, 2, 3}.

// The edge [4, 5] forms another connected component with vertices {4, 5}.

// Therefore, the graph has 3 connected components: {0, 1, 2, 3}, {4, 5}, and the isolated vertices {6} (vertices 6 and any other unconnected vertices).

class Solution {
    public int findNumberOfComponent(int V, List<List<Integer>> edges) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }

        for(List<Integer> edge : edges){
            int a = edge.get(0);
            int b = edge.get(1);
            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        boolean[] visited = new boolean[V];
        int connected = 0;

        for(int i=0;i<V;i++){
            if(!visited[i]){
                dfs(i,adj,visited);
                connected++;
            }
        }
        return connected;
    }

    private void dfs(int node, List<List<Integer>> adj,boolean[] visited){
        visited[node] = true;
        for(int neighbour : adj.get(node)){
            if(!visited[neighbour]){
                dfs(neighbour,adj,visited);
            }
            
        }
    }
         public static void main(String[] args) {
        Solution sol = new Solution();

        int V = 5;
        List<List<Integer>> edges = new ArrayList<>();
        edges.add(Arrays.asList(0, 1));
        edges.add(Arrays.asList(1, 2));
        edges.add(Arrays.asList(3, 4));

        System.out.println("Number of connected components: " + sol.findNumberOfComponent(V, edges));
    }
}

// Bridges in graph

// Given an undirected connected Graph with V vertices (Numbered from 0 to V-1) and E edges. 
// An edge is represented [ai, bi] denoting that there is an edge from vertex ai to bi .
//  An edge is called a bridge if its removal makes some vertex unable to reach another vertex.



// Return all bridges in the graph in any order.


// Example 1





// Input: V = 4, E = [ [0,1],[1,2],[2,0],[1,3] ]

// Output: [ [1, 3] ]

// Explanation: The edge [1, 3] is the critical edge because if we remove the edge the graph will be divided into 2 components.

// Example 2





// Input: V = 3, E = [[0,1],[1,2],[2,0]]

// Result: []

// Explanation: There no bridges in the graph.

class Solution {
    private int timer = 1;
    public List<List<Integer>> criticalConnections(int V, List<List<Integer>> E) {
      ArrayList<ArrayList<Integer>> adj = new  ArrayList<ArrayList<Integer>>();
      for(int i=0;i<V;i++) adj.add(new ArrayList<>());
      for(List<Integer> it : E){
        int u = it.get(0);
        int v = it.get(1);
        adj.get(u).add(v);
        adj.get(v).add(u);
      }

      int[] t = new int[V];
      int[] l = new int[V];
      int[] vis = new int[V];

      List<List<Integer>> bridges = new ArrayList<>();
      dfs(0,-1,bridges,vis,t,l,adj);
      return bridges;
    }
    public void dfs(int node,int parent,List<List<Integer>> bridges,int[] vis,int[] t,int[] l,ArrayList<ArrayList<Integer>> adj){
        vis[node] = 1;
        t[node] = l[node] = timer;
        timer++;
        for(Integer it : adj.get(node)){
            if(it == parent) continue;
            if(vis[it] ==0 ){
                dfs(it,node,bridges,vis,t,l,adj);
                l[node] = Math.min(l[node],l[it]);
                if(l[it] > t[node]){
                    bridges.add(Arrays.asList(it,node));
                }
            }
            else{
                l[node] = Math.min(l[node],l[it]);
            }
        }
    }
}


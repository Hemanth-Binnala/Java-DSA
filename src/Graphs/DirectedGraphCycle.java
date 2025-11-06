// Given a directed graph with V vertices labeled from 0 to V-1.
//  The graph is represented using an adjacency list where adj[i] lists all nodes connected to node.
//  Determine if the graph contains any cycles.

//  Input: V = 6, adj= [ [1], [2, 5], [3], [4], [1], [ ] ]
//  Output: True
// Explanation: The graph contains a cycle: 1 -> 2 -> 3 -> 4 -> 1.

// Input: V = 4, adj= [[1,2], [2], [], [0,2]]



// Output: False
// Explanation: The graph does not contain a cycle.


package Graphs;

import java.util.List;

class Solution {
    public boolean dfs(int node, List<Integer>[] adj,int[] vis, int[]pathVis){
        vis[node] = 1;
        pathVis[node] = 1;
        for(int it : adj[node]){
            if(vis[it] == 0){
                if(dfs(it,adj,vis,pathVis) == true) return true;
            }
            else if(pathVis[it] == 1){
                return true;
            }
        }
        pathVis[node] = 0;
        return false;
    }
    public boolean isCyclic(int N, List<Integer>[] adj) {
        int[] vis = new int[N];
        int[] pathVis = new int[N];
        for(int i=0;i<N;i++){
            if(vis[i] == 0){
                if(dfs(i,adj,vis,pathVis) == true) return true;

            }
        }
      return false;
    }
}

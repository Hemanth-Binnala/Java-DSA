package Graphs;

import java.util.List;

class Solution {
    public boolean isCycle(int V, List<Integer>[] adj) {
        int[] vis = new int[V];
        for(int i=0;i<V;i++){
            if(vis[i] == 0){
                if(dfs(i,-1,adj,vis)){
                    return true;
                }
            }
        }
       return false; 
    }
    public boolean dfs(int node, int parent, List<Integer>[] adj, int[] vis){
        vis[node] =1;
        for(int adjNode : adj[node]){
            if(vis[adjNode] == 0){
                if(dfs(adjNode,node,adj,vis) == true) return true;
            }
            else if(adjNode !=  parent) return true;
        }
        return false;
    }
}

// Given an undirected graph with V vertices labeled from 0 to V-1. The graph is represented using an adjacency list where adj[i] lists all nodes connected to node. Determine if the graph contains any cycles.

// Note: The graph does not contain any self-edges (edges where a vertex is connected to itself).

// Input: V = 6, adj= [[1, 3], [0, 2, 4], [1, 5], [0, 4], [1, 3, 5], [2, 4]]

// Output: True

// Explanation: The graph contains a cycle: 0 ->1 -> 2 -> 5 -> 4 -> 1.

// Input: V = 4, adj= [[1, 2], [0], [0, 3], [2]]

// Output: False

// Explanation: The graph does not contain any cycles.




package Graphs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Pair{
    int first;
    int second;
    Pair(int first,int second){
        this.first = first;
        this.second = second;
    }
}

class Solution {
    public boolean isCycle(int V, List<Integer>[] adj) {
        
        boolean[] vis = new boolean[V];
        for(int i=0;i<V;i++){
            vis[i] = false;
        }
        for(int i=0;i<V;i++){
            if(vis[i] == false){
                if(detectCycle(i,V,adj,vis)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean detectCycle(int src,int V, List<Integer>[] adj, boolean[] vis ){
        vis[src] = true;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(src,-1));
        while(!q.isEmpty()){
            int node = q.peek().first;
            int parent = q.peek().second;
            q.remove();
            for(int adjNode : adj[node]){
                if(vis[adjNode] == false){
                    vis[adjNode] = true;
                    q.add(new Pair(adjNode,node));
                }
                else if(parent != adjNode){
                    return true;
                }
            }

        }
        return false;
    }
}

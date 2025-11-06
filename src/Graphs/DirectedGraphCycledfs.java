// Given a directed graph with V vertices labeled from 0 to V-1.
//  The graph is represented using an adjacency list where adj[i] lists all nodes connected to node. Determine if the graph contains any cycles.
//  Input: V = 6, adj= [ [1], [2, 5], [3], [4], [1], [ ] ]

// Output: True



// Explanation: The graph contains a cycle: 1 -> 2 -> 3 -> 4 -> 1.

// Input: V = 4, adj= [[1,2], [2], [], [0,2]]



// Output: False



// Explanation: The graph does not contain a cycle.







package Graphs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {

    public boolean isCyclic(int N, List<Integer>[] adj) {
        int[] inDegree = new int[N];
        for(int i=0;i<N;i++){
            for(int it : adj[i]){
            inDegree[it]++;                
            }
        }
        Queue<Integer> q = new LinkedList<Integer>();
        for(int i=0;i<N;i++){
            if(inDegree[i] == 0){
                q.add(i);
            }
        }
        int cnt = 0;
        while(!q.isEmpty()){
            int node = q.peek();
            q.remove();
            cnt++;

            for(int it : adj[node]){
                inDegree[it]--;
                if(inDegree[it] == 0){
                    q.add(it);
                }
            }
        }
        if(cnt == N) return false;
        return true;
    }
}


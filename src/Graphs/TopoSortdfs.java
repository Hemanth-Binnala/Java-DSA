package Graphs;

// Given a Directed Acyclic Graph (DAG) with V vertices labeled from 0 to V-1.
// The graph is represented using an adjacency list where adj[i] lists all nodes connected to node. 
// Find any Topological Sorting of that Graph.



// In topological sorting, node u will always appear before node v if there is a directed edge from node u towards node v(u -> v).



// The function should return an array representing the topological order. 
// The output will be validated by our driver code, which checks the correctness of your topological sort. 
// It will print True if the order is valid, otherwise False.

// input: V = 6,adj=[ [ ], [ ], [3], [1], [0,1], [0,2] ]
// Output: [5, 4, 2, 3, 1, 0]

// Explanation: A graph may have multiple topological sortings. 

// Node 5 must appear before 0 and 2
// Node 2 must appear before 3
// Node 3 must appear before 1
// Node 4 must appear before 0 and 1


// One valid topological order is: [5, 4, 2, 3, 1, 0]

// Input: V = 4, adj=[ [ ], [0], [0], [0] ]

// Output: [3, 2, 1, 0]

// Explanation: The necessary conditions for the ordering are:

// Nodes 1, 2, and 3 must all appear before 0.
// Their internal order doesn’t matter.


// One valid topological order is: [3, 2, 1, 0]


import java.util.List;
import java.util.Stack;

class Solution {

    public void dfs(int node,List<Integer>[] adj,int[] vis, Stack<Integer> st){
        vis[node] = 1;
        for(int it : adj[node]){
            if(vis[it] == 0){
                dfs(it,adj,vis,st);
            }
        }
        st.push(node);
    }
    public int[] topoSort(int V, List<Integer>[] adj) {
        int[] vis = new int[V];
        Stack<Integer> st = new Stack<Integer>();
        for(int i=0;i<V;i++){
            vis[i] = 0;
        }

        for(int i=0;i<V;i++){
            if(vis[i] == 0 ){
                dfs(i,adj,vis,st);
            }
        }
        int[] ans = new int[V];
        int i=0;
        while(!st.isEmpty()){
            ans[i++] = st.peek();
            st.pop();
        }
        return ans;
    }
}

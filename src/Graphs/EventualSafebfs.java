// Given a directed graph with V vertices labeled from 0 to V-1.
//  The graph is represented using an adjacency list where adj[i] lists all nodes adjacent to node i, meaning there 
//  is an edge from node i to each node in adj[i]. A node is a terminal node if there are no outgoing edges. A node is a 
//  safe node if every possible path starting from that node leads to a terminal node. Return an array containing all the
//   safe nodes of the graph in ascending order.


// Examples:
// Input: V = 7, adj= [[1,2], [2,3], [5], [0], [5], [], []]
// Output: [2, 4, 5, 6]



// Explanation: 

// From node 0: two paths are there 0->2->5 and 0->1->3->0. 

// The second path does not end at a terminal node. So it is not 

// a safe node.

// From node 1: two paths exist: 1->3->0->1 and 1->2->5.

// But the first one does not end at a terminal node. So it is not a safe node.

// From node 2: only one path: 2->5 and 5 is a terminal node.

// So it is a safe node.

// From node 3: two paths: 3->0->1->3 and 3->0->2->5 

// but the first path does not end at a terminal node. 

// So it is not a safe node.

// From node 4: Only one path: 4->5 and 5 is a terminal node. 

// So it is also a safe node.

// From node 5: It is a terminal node. 

// So it is a safe node as well.

// From node 6: It is a terminal node. 

// So it is a safe node as well.





package Graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public int[] eventualSafeNodes(int V, int[][] adj) {
        int[] inDegree = new int[V];
        List<List<Integer>> revAdj = new ArrayList<>();
        for(int i=0;i<V;i++){
            revAdj.add(new ArrayList<>());
        }

        // for(int i=0;i<V;i++){
        // for(int it : adj[i]){
        //     revAdj.get(it).add(i);
        //     inDegree[i]++;
        // }
        // }
            for (int i = 0; i < adj.length; i++) {
            for (int j = 0; j < adj[0].length; j++) {
            if (adj[i][j] == 1) {
                revAdj.get(j).add(i);
                inDegree[i]++;
            }
        }
    }



        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<V;i++){
            if(inDegree[i]==0){
                q.add(i);
            }
        }

        List<Integer> safenodes = new ArrayList<>();
        while(!q.isEmpty()){
            int node = q.peek();
            q.remove();
            safenodes.add(node);
            for(int it : revAdj.get(node)){
                inDegree[it]--;
                if(inDegree[it] == 0){
                    q.add(it);
                }
            }
        }
        Collections.sort(safenodes);
        int[] ans = new int[safenodes.size()];
        for(int i=0;i<safenodes.size();i++) ans[i] = safenodes.get(i);
        return ans;
    }
}

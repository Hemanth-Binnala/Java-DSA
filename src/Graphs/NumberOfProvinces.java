// Given an undirected graph with V vertices. Two vertices u and v belong to a single province if there is a path from u to v or v to u. Find the number of provinces. The graph is given as an n x n matrix adj where adj[i][j] = 1 if the ith city and the jth city are directly connected, and adj[i][j] = 0 otherwise.



// A province is a group of directly or indirectly connected cities and no other cities outside of the group.


// Examples:


// Input: adj=[ [1, 0, 0, 1], [0, 1, 1, 0], [0, 1, 1, 0], [1, 0, 0, 1] ]

// Output: 2

// Explanation:In this graph, there are two provinces: [1, 4] and [2, 3]. City 1 and city 4 have a path between them, and city 2 and city 3 also have a path between them. There is no path between any city in province 1 and any city in province 2.

// Input: adj= [ [1, 0, 1], [0, 1, 0], [1, 0, 1] ]

// Output: 2

// Explanation: The graph clearly has 2 Provinces [1,3] and [2]. As city 1 and city 3 has a path between them they belong to a single province. City 2 has no path to city 1 or city 3 hence it belongs to another province.







package Graphs;

import java.util.ArrayList;

class Solution {
    public int numProvinces(int[][] adj) {

        int V = adj.length;
        ArrayList<ArrayList<Integer>> adjLS = new ArrayList<ArrayList<Integer>>();
        for(int i =0;i<V;i++){
            adjLS.add(new ArrayList<Integer>());
        }

        for(int i=0;i<V;i++){
            for(int j=0;j<V;j++){
                if(adj[i][j] == 1 && i != j){
                    adjLS.get(i).add(j);
                    adjLS.get(j).add(i);
                }
            }
        }

        int[] visited = new int[V];
        int nop = 0;
        for(int i=0;i<V;i++){
            if(visited[i] ==0){
                nop++;
                dfs(i,adjLS,visited);
            }
        }
        return nop;
        
    }

    private static void dfs(int node, ArrayList<ArrayList<Integer>> adjLS,int[] visited)
    {
        visited[node] = 1;
        for(Integer it : adjLS.get(node)){
            if(visited[it] == 0){
                dfs(it,adjLS,visited);
            }
        }
    }
}



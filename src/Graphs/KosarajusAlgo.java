// Kosaraju's algorithm
// Subscribe to TUF+

// Hints
// Company
// You are given a directed graph with V vertices, numbered from 0 to V − 1,
//  and its adjacency list Adj, where Adj[i] contains all vertices j such that there is a directed edge from vertex i to vertex j.

// Your task is to find the number of strongly connected components (SCCs) in the graph.


// Example 1

// Input: V=5, Adj=[[2,3],[0],[1],[4],[]]





// Output: 3

// Explanation: Three strongly connected components are marked below:





// Example 2

// Input: V=8, Adj=[[1],[2],[0,3],[4],[5,7],[6],[4,7],[]]



// Output: 4

// Explanation: Four strongly connected components are marked below:

class Solution {
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj) {
         int[] vis = new int[V];
         Stack<Integer> st = new Stack<Integer>();
         for(int i=0;i<V;i++){
            if(vis[i] == 0){
                dfs(i,adj,vis,st);
            }
            
         }
         ArrayList<ArrayList<Integer>> adjT = new ArrayList<ArrayList<Integer>>();
         for(int i=0;i<V;i++) adjT.add(new ArrayList<>());
        for(int i=0;i<V;i++){
            vis[i] = 0;
            for(Integer it : adj.get(i))
            adjT.get(it).add(i);
        }
        int scc = 0; 
        while(!st.empty()){
            int q = st.peek();
            st.pop();
            if(vis[q] == 0){
                scc++;
                dfs3(q,vis,adjT);
                    
              
        }
        }
        return scc;
    }
    public void dfs(int node,ArrayList<ArrayList<Integer>> adj,int[] vis,Stack<Integer> st){
        vis[node] = 1;
        for(Integer it : adj.get(node)){
            if(vis[it] == 0){
                dfs(it,adj,vis,st);
            }
            
        }
        st.push(node);
    }
    private void dfs3(int node,int[] vis,ArrayList<ArrayList<Integer>> adjT){
        vis[node] = 1;
        for(Integer it : adjT.get(node)){
            if(vis[it] == 0){
                dfs3(it,vis,adjT);
            }
        }
    }
}






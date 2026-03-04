// Number of operations to make network connected

// Given a graph with n vertices and m edges.
//  The graph is represented by an array Edges, where Edge[i] = [a, b] indicates
//   an edge between vertices a and b. One edge can be removed from anywhere and
//    added between any two vertices in one operation. Find the minimum number of
//     operations that will be required to make the graph connected. If it is not possible 
//     to make the graph connected, return -1.


// Example 1

// Input : n = 4, Edge =[ [0, 1], [ 0, 2], [1, 2]]







// Output: 1

// Explanation: We need a minimum of 1 operation to make
//  the two components connected. We can remove the edge (1,2)
//   and add the edge between node 2 and node 3 like the following:





// Example 2

// Input: n = 9, Edge = [[0,1],[0,2],[0,3],[1,2],[2,3],[4,5],[5,6],[7,8]]







// Output: 2

// Explanation: We need a minimum of 2 operations to make the two
//  components connected. We can remove the edge (0,2) and add the edge
//   between node 3 and node 4 and we can remove the edge (0,3) and add it between nodes 6 and 8 like the following:











class Solution {
    public int makeConnected(int n, int[][] connections) {
        Disjoint ds = new Disjoint(n);
        int r =0;
        for(int[] it : connections){
            int u = it[0];
            int v = it[1];
            if(ds.findParent(u) == ds.findParent(v)) r++;
            else ds.unionBySize(u,v);
        }
        int ans = 0;
        for(int i=0;i<n;i++){
            if(ds.parent[i] == i) ans++;
        }
        int f = ans - 1;
        if(r >= f) return f;
        return -1; 
    }
}

class Disjoint{
    int[] parent;
    int[] size;
    public Disjoint(int n){
        parent = new int[n];
        size = new int[n];
        for(int i=0;i<n;i++){
            parent[i] = i;
            size[i] = 1;
        }
    }
    public int findParent(int node){
        if(node == parent[node]) return node;
        int ulp = findParent(parent[node]);
        parent[node] = ulp;
        return parent[node];
    }
    public void unionBySize(int u, int v){
        int pu = findParent(u);
        int pv = findParent(v);
        if(pu == pv) return;
        if(size[pu] < size[pv]){
            parent[pv] = pu;
            size[pv] += size[pu];
        }
        else{
            parent[pu] = pv;
            size[pu] += size[pv];
        }
    }
}
// Making a large island

// Given an n x n binary matrix grid, 
// it is allowed to change at most one 0 to 1. 
// A group of connected 1s forms an island, where two 1s are connected if they share one of their sides.



// Return the size of the largest island in the grid after applying this operation.


// Example 1

// Input: grid = [[1,0],[0,1]]

// Output: 3

// Explanation: We change any one 0 to 1 and connect two 1s, then we get an island with maximum area = 3.

// Example 2

// Input: grid = [[1,1],[1,1]]

// Output: 4

// Explanation: The largest island already exists with size 4.







class Solution {
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        Disjoint ds = new Disjoint(n*n);
        for(int row=0;row<n;row++){
            for(int col=0;col<n;col++){
                if(grid[row][col] == 0) continue;
                int[] dr = {-1,0,+1,0};
                int[] dc = {0,+1,0,-1};
                for(int ind =0;ind<4;ind++){
                    int newr = row + dr[ind];
                    int newc = col + dc[ind];
                    if(newr >=0 && newc >= 0 && newr < n && newc < n && grid[newr][newc] == 1){
                        int node = row * n + col;
                        int adjNode = newr * n + newc;
                        ds.unionBySize(node,adjNode);
                    }
                }
            }

        }
        int max =0;
        for(int row=0;row<n;row++){
            for(int col=0;col<n;col++){
                if(grid[row][col] == 1) continue;
                int[] dr = {-1,0,+1,0};
                int[] dc = {0,+1,0,-1};
                HashSet<Integer> components = new HashSet<>();
                for(int ind =0;ind<4;ind++){
                    int newr = row + dr[ind];
                    int newc = col + dc[ind];
                    if(newr >=0 && newc >= 0 && newr < n && newc < n && grid[newr][newc] == 1){
                        components.add(ds.findParent(newr * n + newc));
                    }
                }
                int total = 0;
            for(Integer parent : components){
                total += ds.size[parent];
            }
            max = Math.max(max,total+1);
            }
            
        } 
        for(int cellNo=0;cellNo<n*n;cellNo++){
            max = Math.max(max,ds.size[ds.findParent(cellNo)]);
        }
        return max;      
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
        parent[node] = findParent(parent[node]);
        return parent[node];
    }
    public void unionBySize(int u, int v){
        int pu = findParent(u);
        int pv = findParent(v);
        if(pu == pv) return;
        if(size[pu] < size[pv]){
            parent[pu] = pv;
            size[pv] += size[pu];
        }
        else{
            parent[pv] = pu;
            size[pu] += size[pv];          
        }
    }
}
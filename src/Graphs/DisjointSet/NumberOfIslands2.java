// Number of islands II

// Given n, m denoting the row and column of the 2D matrix, and an array A of size k denoting 
// the number of operations. Matrix elements are 0 if there is water or 1 if there is land. Originally, 
// the 2D matrix is all 0 which means there is no land in the matrix.



// The array has k operator(s) and each operator has two integers A[i][0], A[i][1] means
//  that you can change the cell matrix[A[i][0]][A[i][1]] from sea to island. 
//  Return how many islands are there in the matrix after each operation.



// The directions to check for the island are up, down, right, left. The answer array will be of size k.


// Example 1

// Input: n = 4, m = 5, k = 4, A = [[1,1],[0,1],[3,3],[3,4]] 

// Output: [1, 1, 2, 2]

// Explanation: The following illustration is the representation of the operation:



// Example 2

// Input: n = 4, m = 5, k = 12, A = [[0,0],[0,0],[1,1],[1,0],[0,1],[0,3],[1,3],[0,4], [3,2], [2,2],[1,2], [0,2]] 

// Output: [1, 1, 2, 1, 1, 2, 2, 2, 3, 3, 1, 1] 

// Explanation: If we follow the process like in example 1, we will get the above result.

class Solution {
    public List<Integer> numOfIslands(int n, int m, int[][] A) {
        Disjoint ds = new Disjoint(n*m);
        int[][] vis = new int[n][m];
        int cnt = 0;
        List<Integer> ans = new ArrayList<>();
        int l = A.length;
        for(int i=0;i<l;i++){
            int row = A[i][0];
            int col = A[i][1];
            if(vis[row][col] == 1){
                ans.add(cnt);
                continue;
            }
            vis[row][col] = 1;
            cnt++;
            int[] delrow = {-1,0,+1,0};
            int[] delcol = {0,+1,0,-1};
            for(int ind=0;ind<4;ind++){
                int adjrow = row + delrow[ind];
                int adjcol = col + delcol[ind];
                if(adjcol >= 0 && adjrow >= 0 && adjcol < m && adjrow < n && vis[adjrow][adjcol] == 1){
                    int node = row * m + col;
                    int adjNode = adjrow * m + adjcol;
                    if(ds.findParent(node) != ds.findParent(adjNode)){
                        cnt--;
                        ds.unionBySize(node,adjNode);
            
                    }
                }
            }
            ans.add(cnt);
        }
        return ans;
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
    public void unionBySize(int u,int v){
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





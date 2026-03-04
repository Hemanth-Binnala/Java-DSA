// Most stones removed with same row or column

// There are n stones at integer coordinate points on a 2D plane, with at
//  most one stone per coordinate point. Some stones need to be removed.
//  A stone can be removed if it shares the same row or the same column as another stone that has not been removed.



// Given an array of stones of length n where stones[i] = [xi, yi] 
// represents the location of the ith stone, return the maximum possible number of stones that can be removed.


// Example 1

// Input : n=6, stones = [[0, 0],[ 0, 1], [1, 0],[1, 2],[2, 1],[2, 2]]

// Output: 5

// Explanation: One of the many ways to remove 5 stones is to remove the following stones:

// [0,0], [1,0], [0,1], [2,1], [1,2]

// Example 2

// Input : n = 6, stones = [[0, 0], [0, 2], [1, 3], [3, 1], [3, 2], [4, 3]]

// Output: 4

// Explanation: We can remove the following stones: [0,0], [0,2], [1,3], [3,1]

class Solution {
    public int removeStones(int[][] stones) {
        int n = stones.length;
        int maxRow = 0;
        int maxCol = 0;
        for(int i=0;i<n;i++){
            maxRow = Math.max(maxRow,stones[i][0]);
            maxCol = Math.max(maxCol,stones[i][1]);
        }
        Disjoint ds = new Disjoint(maxRow + maxCol + 2);
        HashMap<Integer, Integer> stoneNodes = new HashMap<>(); 
        for(int i=0;i<n;i++){
            int nodeRow =stones[i][0];
            int nodeCol = stones[i][1] + maxRow + 1;
            ds.unionBySize(nodeRow,nodeCol);
            stoneNodes.put(nodeRow,1);
            stoneNodes.put(nodeCol,1);
        }
        int cnt =0;
        for(Map.Entry<Integer, Integer> it : stoneNodes.entrySet()){
            if(ds.findParent(it.getKey()) == it.getKey()) cnt++;
        }
        return n - cnt;
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
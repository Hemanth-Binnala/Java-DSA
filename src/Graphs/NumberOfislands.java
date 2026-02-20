// Given a grid of size N x M (N is the number of rows and M is the number of columns in the grid) consisting of '0's (Water) 
// and ‘1's(Land). Find the number of islands.

// An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically or diagonally i.e., in all 8 directions.
// Input: grid = [ ["1", "1", "1", "0", "1"], ["1", "0", "0", "0", "0"], ["1", "1", "1", "0", "1"], ["0", "0", "0", "1", "1"] ]

["1", "1", "1", "0", "1"]
["1", "0", "0", "0", "0"]
["1", "1", "1", "0", "1"]
["0", "0", "0", "1", "1"]

// Output: 3

// Explanation: This grid contains 2 islands. Each '1' represents a piece of land, and the islands are formed by connecting 
// adjacent lands horizontally or vertically. Despite some islands having a common edge, they are considered separate islands because there 
// is no land connectivity in any of the eight directions between them. Therefore, the grid contains 2 islands.

// Input: grid = [ ["1", "0", "0", "0", "1"], ["0", "1", "0", "1", "0"], ["0", "0", "1", "0", "0"], ["0", "1", "0", "1"," 0"] ]

// Output: 1

// Explanation: In the given grid, there's only one island as all the '1's are connected either horizontally
// , vertically, or diagonally, forming a single contiguous landmass surrounded by water on all sides.

package Graphs;

import java.util.ArrayList;
import java.util.HashSet;

class Solution {

    private void dfs(int row,int col,int[][] vis,char[][] grid,ArrayList<String> vec,int row0,int col0){
       int n = grid.length;
       int m = grid[0].length;
       vis[row][col] =1;
       vec.add(toString(row - row0,col - col0));
       int[] delrow = {-1,0,+1,0};
       int[] delcol = {0,+1,0,-1};
       for(int i=0;i<4;i++){
        int nrow = row + delrow[i];
        int ncol = col + delcol[i];
        if(nrow >=0 && nrow < n && ncol >=0 && ncol < m 
        && vis[nrow][ncol]==0 && grid[nrow][ncol] == '1'){
            dfs(nrow,ncol,vis,grid,vec,row0,col0);
        }
       }
    }
    private String toString(int r,int c){
        return Integer.toString(r) + " " + Integer.toString(c);
    }
    public int numIslands(char[][] grid) {
       int n = grid.length;
       int m = grid[0].length;
       int[][] vis = new int[n][m];
       HashSet<ArrayList<String>> st = new HashSet<>();
       for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            if(vis[i][j] == 0 && grid[i][j] == '1'){
                ArrayList<String> vec = new ArrayList<>();
                dfs(i,j,vis,grid,vec,i,j);
                st.add(vec);
            }
        }
       }
       return st.size();
    }
}



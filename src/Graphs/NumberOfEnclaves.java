// Given an N x M binary matrix grid, where 0 represents a sea cell and 1 represents a land cell.
//  A move consists of walking from one land cell to another adjacent (4-directionally) land cell or walking off the boundary of the grid. 
//  Find the number of land cells in the grid for which we cannot walk off the boundary of the grid in any number of moves.
//  Input: grid = [[0, 0, 0, 0], [1, 0, 1, 0], [0, 1, 1, 0], [0, 0, 0, 0]]

// Output: 3

// Input: grid = [[0, 0, 0, 1],[0, 0, 0, 1], [0, 1, 1, 0], [0, 0, 1, 0], [0, 0, 0, 0]]

// Output:3

package Graphs;

import java.util.LinkedList;
import java.util.Queue;

class Pair{
    int first;
    int second;
    Pair(int first,int second){
        this.first = first;
        this.second = second;
    }
}

class Solution {
    public int numberOfEnclaves(int[][] grid) {
            int n = grid.length;
            int m = grid[0].length;
            int[][] vis = new int[n][m];
            Queue<Pair> q = new LinkedList<>();
            for(int i=0; i<n;i++){
                for(int j=0;j<m;j++){
                    if(i==0 || j==0 || i == n-1 || j == m-1){
                        if(grid[i][j] == 1){
                            q.add(new Pair(i,j));
                            vis[i][j] = 1;
                        }
                    }
                }
            }

            int[] delrow = {-1,0,+1,0};
            int[] delcol = {0,+1,0,-1};


            while(!q.isEmpty()){
                int row = q.peek().first;
                int col = q.peek().second;
                q.remove();
                for(int i=0;i<4;i++){
                    int nrow = row + delrow[i];
                    int ncol = col + delcol[i];
                    if(nrow >=0 && nrow < n && ncol>=0 && ncol <m 
                    && vis[nrow][ncol] == 0 && grid[nrow][ncol]==1){
                        q.add(new Pair(nrow,ncol));
                        vis[nrow][ncol] = 1;
                    }
                }
            }
            int cnt = 0;
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(vis[i][j] ==0 && grid[i][j] == 1){
                        cnt++;
                    } 
                }
            }
        return cnt;
    }
}

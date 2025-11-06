// Given a binary grid of N x M. Find the distance of the nearest 1 in the grid for each cell.



// The distance is calculated as |i1 - i2| + |j1 - j2|, where i1, j1 are the row number and column number of the current cell, and i2, j2 are the row number and column number of the nearest cell having value 1.

// Input: grid = [ [0, 1, 1, 0], [1, 1, 0, 0], [0, 0, 1, 1] ]

// Output: [ [1, 0, 0, 1], [0, 0, 1, 1], [1, 1, 0, 0] ]

// Explanation: 0's at (0,0), (0,3), (1,2), (1,3), (2,0) and (2,1) are at a distance of 1 from 1's at (0,1),(0,2), (0,2), (2,3), (1,0) and (1,1) respectively.

// Input: grid = [ [1, 0, 1], [1, 1, 0], [1, 0, 0] ]

// Output: [ [0, 1, 0], [0, 0, 1], [0, 1, 2] ]

// Explanation: 0's at (0,1), (1,2), (2,1) and (2,2) are at a distance of 1, 1, 1 and 2 from 1's at (0,0),(0,2), (2,0) and (1,1) respectively.

package Graphs;

import java.util.LinkedList;
import java.util.Queue;

class Pair{
    int first;
    int second;
    int dis;
    Pair(int first,int second,int dis){
        this.first = first;
        this.second = second;
        this.dis = dis;
    }
}

class Solution {
    public int[][] nearest(int[][] grid) {
       int n = grid.length;
       int m = grid[0].length;

       int[][] vis = new int[n][m];
       int[][] disArr = new int[n][m];
       Queue<Pair> q = new LinkedList<>();

       for(int i=0; i<n;i++){
        for(int j=0;j<m;j++){
            if(grid[i][j] == 1){
                q.add(new Pair(i,j,0));
                vis[i][j] = 1 ;
            }
            else{
                vis[i][j] = 0;
            }
        }
       }
       
       int[] delrow = {-1,0,+1,0};
       int[] delcol = {0,+1,0,-1};

       while(!q.isEmpty()){
        int row = q.peek().first;
        int col = q.peek().second;
        int dis = q.peek().dis;
        q.remove();
        disArr[row][col] = dis;
        for(int i=0;i<4;i++){
            int nrow = row + delrow[i];
            int ncol = col + delcol[i];
            if(nrow >= 0 && nrow < n && ncol >= 0  && ncol < m && vis[nrow][ncol] == 0){
                vis[nrow][ncol] = 1;
                q.add(new Pair(nrow,ncol,dis+1));
            }

        }
        
       }
       return disArr;
    }
}

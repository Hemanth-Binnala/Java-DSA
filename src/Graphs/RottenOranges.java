// Given an n x m grid, where each cell has the following values : 



// 2 - represents a rotten orange

// 1 - represents a Fresh orange

// 0 - represents an Empty Cell

// Every minute, if a fresh orange is adjacent to a rotten orange in 4-direction ( upward, downwards, right, and left ) it becomes rotten. 



// Return the minimum number of minutes required such that none of the cells has a Fresh Orange. If it's not possible, return -1.


// Examples:
// Input: grid = [ [2, 1, 1] , [0, 1, 1] , [1, 0, 1] ]

// Output: -1

// Explanation: Orange at (3,0) cannot be rotten.

// Input: grid = [ [2,1,1] , [1,1,0] , [0,1,1] ] 

// Output: 4




package Graphs;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<Pair> q = new LinkedList<>();

        int[][] vis = new int[n][m];
        int cntFrsh = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 2){
                    q.add(new Pair(i,j,0));
                    vis[i][j] =2;
                }
                else{
                    vis[i][j] = 0;
                }
                if(grid[i][j] == 1){
                    cntFrsh++;
                }
            }
        }
        int tm=0;
        int[] delrow = {-1,0,+1,0};
        int[] delcol = {0,+1,0,-1};
        int cnt = 0;
        while(!q.isEmpty()){
            int r = q.peek().row;
            int c = q.peek().col;
            int t = q.peek().tm;
            q.remove();
            tm = Math.max(tm,t);
            for(int i=0;i<4;i++){
                int nrow = r + delrow[i];
                int ncol = c + delcol[i];
                if(nrow >=0 && nrow < n && ncol >=0 && ncol < m
                && vis[nrow][ncol] == 0 && grid[nrow][ncol] == 1){
                    q.add(new Pair(nrow,ncol,t+1));
                    vis[nrow][ncol] = 2;
                    cnt++;
                }
            }
            
        }
        if(cnt != cntFrsh) return -1;
            return tm;
    }
}

class Pair{
    int row;
    int col;
    int tm;
    Pair(int _row, int _col,int _tm){
        this.row = _row;
        this.col = _col;
        this.tm = _tm;
    }
}



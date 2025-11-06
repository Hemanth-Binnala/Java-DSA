// You are given a matrix mat of size N x M where each cell contains either 'O' or 'X'.

// Your task is to replace all 'O' cells that are completely surrounded by 'X' with 'X'.



// Rules:

// An 'O' (or a group of connected 'O's) is considered surrounded if it is not connected to any border of the matrix.
// Two 'O' cells are considered connected if they are adjacent horizontally or vertically (not diagonally).
// A region of connected 'O's that touches the border (i.e., first row, last row, first column, or last column) is not surrounded and should not be changed.

// Examples:

// Input: mat = [ ["X", "X", "X", "X"], ["X", "O", "O", "X"], ["X", "X", "O", "X"], ["X", "O", "X", "X"] ]

// Output: [ ["X", "X", "X", "X"], ["X", "X", "X", "X"], ["X", "X", "X", "X"], ["X", "O", "X", "X"] ]

// The 'O' cells at positions (1,1), (1,2), (2,2), and (3,1) are surrounded by 'X' cells in all directions (horizontally and vertically).

// However, the 'O' region at (3,1) is adjacent to an edge of the board, so it cannot be completely surrounded by 'X' cells. Therefore, it remains unchanged.

// Input: mat = [ ["X", "X", "X"], ["X", "O", "X"], ["X", "X", "X"] ]

// Output: [ ["X", "X", "X"], ["X", "X", "X"], ["X", "X", "X"] ]

// Explanation: The only 'O' cell at position (1,1) is completely surrounded by 'X' cells in all directions (horizontally and vertically). Hence, it is replaced with 'X' in the output.

package Graphs;

class Solution {
    public void dfs(int n,int m,int row,int col,int[][] vis,
    char[][] mat,int[] delrow, int[] delcol){
        vis[row][col] = 1;
        for(int i=0;i<4;i++){
            int nrow = row + delrow[i];
            int ncol = col + delcol[i];
            if(nrow >=0 && nrow < n && ncol >= 0 && ncol < m &&
            vis[nrow][ncol]==0 && mat[nrow][ncol] == 'O'){
                vis[nrow][ncol]=1;
                dfs(n,m,nrow,ncol,vis,mat,delrow,delcol);
            }
        }
    }
    public char[][] fill(char[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int[][] vis = new int[n][m];
        int[] delrow = {-1,0,+1,0};
        int[] delcol = {0,+1,0,-1};

        for(int i=0;i<n;i++){
            if(vis[i][0] == 0 && mat[i][0] == 'O'){
                dfs(n,m,i,0,vis,mat,delrow,delcol);
            }
            if(vis[i][m-1] == 0 && mat[i][m-1] == 'O'){
                dfs(n,m,i,m-1,vis,mat,delrow,delcol);
            }
        }
        for(int i=0;i<m;i++){
            if(vis[0][i] == 0 && mat[0][i] == 'O'){
                dfs(n,m,0,i,vis,mat,delrow,delcol);
            }
            if(vis[n-1][i] == 0 && mat[n-1][i] == 'O'){
                dfs(n,m,n-1,i,vis,mat,delrow,delcol);
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j] == 0 && mat[i][j] == 'O'){
                    mat[i][j] = 'X';
                }
            }
        }
        return mat;

    }
}

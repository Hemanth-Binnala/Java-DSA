// An image is represented by a 2-D array of integers, each integer representing the pixel value of the image. Given a coordinate (sr, sc) representing the starting pixel (row and column) of the flood fill, and a pixel value newColor, "flood fill" the image.



// To perform a flood fill, consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same colour as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same colour as the starting pixel), and so on. Replace the colour of all of the aforementioned pixels with the newColor.


// Examples:

// Input: image = [ [1, 1, 1], [1, 1, 0], [1, 0, 1] ], sr = 1, sc = 1, newColor = 2

// Output: [ [2, 2, 2], [2, 2, 0], [2, 0, 1] ]

// Explanation: From the center of the image with position (sr, sc) = (1, 1) (i.e., the red pixel), all pixels connected by a path of the same color as the starting pixel (i.e., the blue pixels) are colored with the new color.

// Note the bottom corner is not colored 2, because it is not 4-directionally connected to the starting pixel.

// Input: image = [ [0, 1, 0], [1, 1, 0], [0, 0, 1] ], sr = 2, sc = 2, newColor = 3

// Output: [ [0, 1, 0], [1, 1, 0], [0, 0, 3] ]

// Explanation: Starting from the pixel at position (2, 2) (i.e., the blue pixel), we flood fill all adjacent pixels that have the same color as the starting pixel. In this case, only the pixel at position (2, 2) itself is of the same color. So, only that pixel gets colored with the new color, resulting in the updated image.






package Graphs;

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int[][] ans = image;
        int inicol = image[sr][sc];
        int[] delrow = {-1,0,+1,0};
        int[] delcol = {0,+1,0,-1};
        dfs(image,ans,inicol,delrow,delcol,sr,sc,newColor);
        return ans;
    }

    private void dfs(int[][] image, int[][] ans,int inicol, int delrow[],
    int delcol[],int row, int col,int newColor){
        ans[row][col] = newColor;
        int n = image.length;
        int m = image[0].length;
        for(int i=0;i<4;i++){
            int nrow = row + delrow[i];
            int ncol = col + delcol[i];
            if(nrow >=0 && nrow < n && ncol>=0 && ncol < m &&
            image[nrow][ncol] == inicol && ans[nrow][ncol] != newColor
            ){
                dfs(image,ans,inicol,delrow,delcol,nrow,ncol,newColor);
            }
        }
    }
}

// Floyd warshall algorithm

// Given a graph of V vertices numbered from 0 to V-1.
//  Find the shortest distances between every pair of vertices in a 
//  given edge-weighted directed graph. The graph is represented as an 
//  adjacency matrix of size n x n. Matrix[i][j] denotes the weight of the 
//  edge from i to j. If matrix[i][j]=-1, it means there is no edge from i to j.


// Example 1

// Input: matrix = [[0, 2, -1, -1],[1, 0, 3, -1],[-1, -1, 0, 1],[3, 5, 4, 0]]

// Output: [[0, 2, 5, 6], [1, 0, 3, 4], [4, 6, 0, 1], [3, 5, 4, 0]] 

// Explanation: matrix[0][0] is storing the distance from vertex 0 to vertex 0, the distance from vertex 0 to vertex 1 is 2 and so on.

// Example 2

// Input: matrix = [[0,25],[-1,0]]

// Output: [[0, 25],[-1, 0]]

// Explanation: The matrix already contains the shortest distance.

class Solution {
    public void shortestDistance(int[][] matrix) {
        int n = matrix.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
               if(matrix[i][j] == -1) matrix[i][j] = (int)(1e9);
               if(i==j) matrix[i][j] = 0;
            }
        }
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    matrix[i][j] = Math.min(matrix[i][j],matrix[i][k] + matrix[k][j]);
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
               if(matrix[i][j] == (int)1e9) matrix[i][j] = -1;
            }
        }
       
    }

}


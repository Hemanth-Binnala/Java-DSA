// Shortest Distance in a Binary Maze

// Given an n x m matrix grid where each cell contains either 0 or 1, determine the shortest distance between a source cell and a destination cell. You can move to an adjacent cell (up, down, left, or right) if that adjacent cell has a value of 1. The path can only be created out of cells containing 1. If the destination cell is not reachable from the source cell, return -1.


// Example 1

// Input: grid = [[1, 1, 1, 1],[1, 1, 0, 1],[1, 1, 1, 1],[1, 1, 0, 0],[1, 0, 0, 1]], source = [0, 1], destination = [2, 2]

// Output: 3

// Explanation: The shortest path from (0, 1) to (2, 2) is:

// Move down to (1, 1)

// Move down to (2, 1)

// Move right to (2, 2)

// Thus, the shortest distance is 3

// Example 2

// Input: grid = [[1, 1, 1, 1, 1],[1, 1, 1, 1, 1],[1, 1, 1, 1, 0],[1, 0, 1, 0, 1]], source = [0, 0], destination = [3, 4]

// Output: -1

// Explanation: 

// Since, there is no path possible between the source cell and the destination cell, hence we return -1.


class Tuple{
    int distance;
    int first;
    int second;
    Tuple(int distance,int first,int second){
        this.distance = distance;
        this.first = first;
        this.second = second;
    }
}

class Solution {
    int shortestPath(int[][] grid, int[] source, int[] destination) {
        if(source[0] == destination[0] && source[1] == destination[1]) return 0;
        int n = grid.length;
        int m = grid[0].length;
        int[][] dist = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dist[i][j] = (int)(1e9);
            }
        }
        Queue<Tuple> t = new LinkedList<>();
        dist[source[0]][source[1]] = 0;
        t.add(new Tuple(0,source[0],source[1]));
        int[] dr = {-1,0,+1,0};
        int[] dc = {0,+1,0,-1};
        while(!t.isEmpty()){
            int d = t.peek().distance;
            int r = t.peek().first;
            int c = t.peek().second;
            t.remove();
            for(int i=0;i<4;i++){
                int newr = r + dr[i];
                int newc = c + dc[i];
                if(newr >=0 && newr < n && newc >=0 && newc < m && grid[newr][newc] == 1 && (d + 1) < dist[newr][newc] ){
                    if(newr == destination[0] && newc == destination[1]) return d+1;
                    dist[newr][newc] = d + 1;
                    t.add(new Tuple(d+1,newr,newc));
                }
            }
        }
        return -1;
    }
}


// A hiker is preparing for an upcoming hike. Given heights, a 2D array of size rows x columns,
//  where heights[row][col] represents the height of the cell (row, col). The hiker is situated i
// n the top-left cell, (0, 0), and hopes to travel to the bottom-right cell, (rows-1, columns-1)
//  (i.e.,0-indexed). He can move up, down, left, or right. He wishes to find a route that requires the minimum effort.



// A route's effort is the maximum absolute difference in heights between two consecutive cells of the route.


// Example 1

// Input: heights = [[1,2,2],[3,8,2],[5,3,5]]

// Output: 2

// Explanation: The route of [1,3,5,3,5] has a maximum absolute difference of 2 in consecutive cells.
//  This is better than the route of [1,2,2,2,5], where the maximum absolute difference is 3.

// Example 2

// Input: heights = [[1,2,3],[3,8,4],[5,3,5]]

// Output: 1

// Explanation: The route of [1,2,3,4,5] has a maximum absolute difference of
//  1 in consecutive cells, which is better than route [1,3,5,3,5].

class Tuple{
    int distance;
    int row;
    int col;
    Tuple(int distance,int row,int col){
        this.distance = distance;
        this.row = row;
        this.col = col; 
    }
}

class Solution {
    public int MinimumEffort(List<List<Integer>> heights) {
        int n = heights.size();
        int m = heights.get(0).size();
        int[][] dist = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dist[i][j] = (int)(1e9); 
            }
        }
        PriorityQueue<Tuple> t = new PriorityQueue<>((x,y) -> x.distance - y.distance);
        dist[0][0] = 0;
        t.add(new Tuple(0,0,0));
        int[] dr = {-1,0,+1,0};
        int[] dc = {0,+1,0,-1};

        while(!t.isEmpty()){
            int d = t.peek().distance;
            int r = t.peek().row;
            int c = t.peek().col;
            t.remove();
            if(r == n-1 && c == m-1) return d;
            for(int i=0;i<4;i++){
                int newr = r + dr[i];
                int newc = c + dc[i];

                if(newr >=0 && newr < n && newc >=0 && newc < m){
                    int newEffort = Math.max(Math.abs(heights.get(newr).get(newc) - heights.get(r).get(c)),d);
                    if(newEffort < dist[newr][newc]){
                        dist[newr][newc] = newEffort;
                        t.add(new Tuple(newEffort,newr,newc));
                    }
                }
            }
        }
        return 0;
    }
}

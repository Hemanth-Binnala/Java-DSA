// Given a weighted and directed graph of V vertices and E edges. 
// An edge is represented as [ai, bi, wi], meaning there is a directed edge
//  from ai to bi having weight wi. Find the shortest distance of all the vertices 
// from the source vertex S. If a vertex can't be reached from the S then mark the distance as 109.



// If the graph contains a negative cycle then return -1 in a list.


// Example 1





// Input : V = 6, Edges = [[3, 2, 6], [5, 3, 1], [0, 1, 5], [1, 5, -3], [1, 2, -2], [3, 4, -2], [2, 4, 3]], S = 0

// Output: 0 5 3 3 1 2

// Explanation:

// For node 1, shortest path is 0->1 (distance=5).

// For node 2, shortest path is 0->1->2 (distance=3)

// For node 3, shortest path is 0->1->5->3 (distance=3)

// For node 4, shortest path is 0->1->5->3->4 (distance=1)

// For node 5, shortest path is 0->1->5 (distance=2)

// Example 2

// Input : V = 2, Edges = [[0,1,9]], S = 0

// Output: 0 9

// Explanation: For node 1, the shortest path is 0->1 (distance=9)


class Solution {
    static int[] bellman_ford(int V,
                              ArrayList<ArrayList<Integer>> edges, int S) {
    int[] dist = new int[V];
    for(int i=0;i<V;i++) dist[i] = (int)1e8;
    dist[S] = 0;
    for(int i=0;i<V-1;i++){
        for(ArrayList<Integer> it : edges){
            int u = it.get(0);
                int v = it.get(1);
                int wt = it.get(2);
            if(dist[u] != (int)(1e8) && dist[u] + wt < dist[v]){
                dist[v] = dist[u] + wt;
            }
        }
    }
    for(ArrayList<Integer> it : edges){
        int u = it.get(0);
                int v = it.get(1);
                int wt = it.get(2);
            if(dist[u] != (int)(1e8) && dist[u] + wt < dist[v]){
                int[] temp = new int[1];
                temp[0] = -1;
                return temp;
            }
    }
    return dist;
    }
}
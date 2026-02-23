// Network Delay Time

// You are given a directed weighted graph representing a communication network with n nodes, numbered from 1 … n.

// The graph is provided as an edge list times, where each record is of the form (ui, vi, wi) where,

// ui — the source node of the directed edge
// vi — the target node of the directed edge
// wi — the time it takes for a signal to travel from ui to vi (non-negative and integer)


// A single signal is injected at node k at time 0.

// The signal propagates 1-way along the directed edges; whenever it reaches a node,
//  that node immediately retransmits the signal to all of its outgoing neighbors, 
//  each traversal taking exactly the edge’s weight wi units of time.



// Return the minimum time required for every node in the network to receive the signal.

// If some node is unreachable, return -1.


// Example 1

// Input: times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2

// Output: 2

// Explanation:

//  2 →1 (1 unit)  2 →3 (1 unit) →4 ( +1 unit )

//  The last node (4) gets the signal at time 2.

// Example 2

// Input: times = [[1,2,1]], n = 2, k = 1

// Output: 1

// Explanation:

//  Direct edge 1 → 2 delivers the signal in 1 unit of time.



class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
      List<List<int[]>> adj = new ArrayList<>();
      for(int i=0;i<=n;i++) adj.add(new ArrayList<>());
      for(int[] edge : times){
        int u = edge[0];
        int v = edge[1];
        int wt = edge[2];
        adj.get(u).add(new int[]{v,wt});
      }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);

        int[] dist = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[k] =0;
        pq.add(new int[]{0,k});
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int d = curr[0];
            int node = curr[1];
            if(d > dist[node]) continue;
            for(int[] it : adj.get(node)){
                int adjNode = it[0];
                int edw = it[1];
                if(d+edw < dist[adjNode]){
                    dist[adjNode] = d + edw;
                    pq.add(new int[]{d+edw,adjNode});
                }
            }
        }
      int max = 0;
      for(int i=1;i<=n;i++){
        if(dist[i] == Integer.MAX_VALUE) return -1;
        max = Math.max(max,dist[i]);
      }
      return max;
    }
}
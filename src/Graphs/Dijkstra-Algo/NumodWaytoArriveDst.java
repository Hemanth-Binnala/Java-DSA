// Number of ways to arrive at destination

// A city consists of n intersections numbered from 0 to n - 1 with bi-directional roads between some intersections.
//  The inputs are generated such that one can reach any intersection from any other intersection and that
//   there is at most one road between any two intersections.



// Given an integer n and a 2D integer array ‘roads’ where roads[i] = [ui, vi, timei] means
//  that there is a road between intersections ui and vi that takes timei minutes to travel.
//   Determine the number of ways to travel from intersection 0 to intersection n - 1 in the shortest amount of time.



// Since the answer may be large, return it modulo 109 + 7.

// Input: n=7, m=10, roads= [[0,6,7],[0,1,2],[1,2,3],[1,3,3],[6,3,3],[3,5,1],[6,5,1],[2,5,1],[0,4,5],[4,6,2]]

// Output: 4

// Explanation: 

// The four ways to get there in 7 minutes (which is the shortest calculated time) are:

// - 0 6

// - 0 4 6

// - 0 1 2 5 6

// - 0 1 3 5 6

// Input: n=6, m=8, roads= [[0,5,8],[0,2,2],[0,1,1],[1,3,3],[1,2,3],[2,5,6],[3,4,2],[4,5,2]]

// Output: 3

// Explanation: 

// The three ways to get there in 8 minutes (which is the shortest calculated time) are:

// - 0 5

// - 0 2 5

// - 0 1 3 4 5

class Pair{
    int first,second;
    Pair(int first,int second){
        this.first = first;
        this.second = second;
    }
}

class Solution {
    public int countPaths(int n, List<List<Integer>> roads) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        int m = roads.size();
        for(int i=0;i<m;i++){
            adj.get(roads.get(i).get(0)).add(new Pair(roads.get(i).get(1),roads.get(i).get(2)));
            adj.get(roads.get(i).get(1)).add(new Pair(roads.get(i).get(0),roads.get(i).get(2)));
        }
        int[] dist = new int[n];
        int[] ways = new int[n];

        for(int i=0;i<n;i++){
            dist[i] = (int)1e9;
            ways[i] = 0;
        }

        int mod = (int)(1e9 + 7);
        dist[0] = 0;
        ways[0] = 1;
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y) -> x.first - y.first);
        pq.add(new Pair(0,0));
        while(!pq.isEmpty()){
            int d = pq.peek().first;
            int node = pq.peek().second;
            pq.remove();
            for(Pair it : adj.get(node)){
                int adjNode = it.first;
                int edw = it.second;
                if(d+edw < dist[adjNode]){
                    dist[adjNode] = d + edw;
                    pq.add(new Pair(d+edw,adjNode));
                    ways[adjNode] = ways[node];
                }
                else if(d + edw == dist[adjNode]){
                    ways[adjNode] = (ways[adjNode] + ways[node]) % mod;
                }
            }
        }
        return ways[n-1] % mod;
     }
}

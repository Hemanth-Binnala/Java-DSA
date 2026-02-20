// Cheapest flight within K stops

// There are n cities and m edges connected by some number of flights.
//  Given an array of flights where flights[i] = [ fromi, toi, pricei] 
//  indicates that there is a flight from city fromi to city toi with cost pricei.
//   Given three integers src, dst, and k, and return the cheapest price from src to dst with at most k stops.
//    If there is no such route, return -1.

//    Input: n = 4, flights = [[0,1,100],[1,2,100],[2,0,100],[1,3,600],[2,3,200]], src = 0, dst = 3, k = 1

// Output: 700

// Explanation: The optimal path with at most 1 stops from city 0 to 3 is marked in red and has cost 100 + 600 = 700.

// Note that the path through cities [0,1,2,3] is cheaper but is invalid because it uses 2 stops.

// Input: n = 3, flights = [[0,1,100],[1,2,100],[0,2,500]], src = 0, dst = 2, k = 1

// Output: 200

// Explanation:The optimal path with at most 1 stops from city 0 to 2 is marked in red and has cost 100 + 100 = 200.


class Pair{
    int first;
    int second;
    Pair(int first,int second){
        this.first = first;
        this.second = second;
    }
}

class Tuple {
    int first;
    int second;
    int third;
    Tuple(int first,int second,int third){
        this.first = first;
        this.second = second;
        this.third = third;
    }
}

class Solution {
    public int CheapestFlight(int n, int[][] flights, int src, int dst, int K) {
      ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
      for(int i=0;i<n;i++){
        adj.add(new ArrayList<>());
      }
      int m = flights.length;
      for(int i=0;i<m;i++){
        adj.get(flights[i][0]).add(new Pair(flights[i][1],flights[i][2]));
      }

      int[] dist = new int[n];
      for(int i=0;i<n;i++) dist[i] = (int)1e9;

      Queue<Tuple> q = new LinkedList<>();
      q.add(new Tuple(0,src,0));
      dist[src] = 0;
      while(!q.isEmpty()){
        int stops = q.peek().first;
        int node = q.peek().second;
        int cost = q.peek().third;

        q.remove();
        if(stops > K) continue;
        for(Pair it : adj.get(node)){
            int adjNode = it.first;
            int edw = it.second;
            if(cost + edw < dist[adjNode] && stops <= K){
                dist[adjNode] = cost + edw;
                q.add(new Tuple(stops+1,adjNode,dist[adjNode]));
            }
        }
      }
      if(dist[dst] == (int)1e9) return -1;
      return dist[dst];
    }
}


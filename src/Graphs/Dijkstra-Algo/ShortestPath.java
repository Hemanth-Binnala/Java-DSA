// to find the shortest path we use Dijkstra algo with one more array which memoizes the parent node details.

class Pair{
    int distance;
    int node;
    Pair(int distance,int node){
        this.distance = distance;
        this.node = node;
    }
}

class Solution
{
    public  static List<Integer> shortestPath(int n,int m , int[][] edges){
        ArrayList<ArrayList<Pair>>  adj = new ArrayList<>();
        for(int i=0;i<=n;i++) adj.add(new ArrayList<>());
        for(int i=0;i<m;i++){
            adj.get(edges[i][0]).add(new Pair(edges[i][1],edges[i][2]));
            adj.get(edges[i][1]).add(new Pair(edges[i][0],edges[i][2]));
        }
        int[] dist = new int[n+1];
        int[] parent = new int[n+1];
        for(int i=1;i<=n;i++){
            dist[i] = (int)(1e9);
            parent[i] = i;
        }
        dist[1] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y) -> x.distance - y.distance);
        pq.add(new Pair(0,1));
        while(!pq.isEmpty()){
            int dis = pq.peek().distance;
            int node = pq.peek().node;
            pq.remove();
            for(Pair it : adj.get(node)){
                int adjNode = it.node;
                int edgeWeight = it.distance;
                if(dis + edgeWeight < dist[adjNode]){
                    dist[adjNode] = dis + edgeWeight;
                    pq.add(new Pair(dist[adjNode],adjNode));
                    parent[adjNode] = node;
                }
            }
        }
        List<Integer> path = new ArrayList<>();
        if(dist[n] == 1e9){
            path.add(-1);
            return path;
        } 
        int node = n;
        while(parent[node] != node){
            path.add(node);
            node = parent[node];
        }
        path.add(1);
        Collections.reverse(path);
        return path;
    }
}
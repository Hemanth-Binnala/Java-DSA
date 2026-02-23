// Find the city with the smallest number of neighbors

// There are n cities numbered from 0 to n-1.
//  Given the array edges where edges[i] = [fromi, toi,weighti] represents a
//   bidirectional and weighted edge between cities fromi and toi, and given 
//   he integer distance Threshold. Find out a city with the smallest number of 
//   cities that are reachable through some path and whose distance is at most Threshold Distance.

//   Input : N=4, M=4, edges = [[0,1,3],[1,2,1],[1,3,4],[2,3,1]], distanceThreshold = 4



// Output: 3



// Explanation: 

// The adjacent cities for each city at a distanceThreshold are =

// City 0 →[City 1, City 2]

// City 1 →[City 0, City 2, City 3]

// City 2 →[City 0, City 1, City 3]

// City 3 →[City 1, City 2]

// Here, City 0 and City 3 have a minimum number of cities 

// i.e. 2 within distanceThreshold. So, the result will be the 

// city with the largest number. So, the answer is City 3.

// Input : N=3, M=2, edges = [[0,1,1],[0,2,3]], distanceThreshold = 2



// Output: 2



// Explanation: 

// City 0 -> City 1,

// City 1 → City 0,

// City 2 → no City

// Hence, 2 is the answer.



// If there are multiple such cities, our answer will be the city with the greatest number.

class Solution {

    public int findCity(int n, int m, int edges[][],
                 int distanceThreshold) {
        int[][] dist = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i == j) dist[i][j] = 0;
                else dist[i][j] = Integer.MAX_VALUE;
            }
        }
        for(int i=0;i<m;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            dist[u][v] = wt;
            dist[v][u] = wt;
        }

        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(dist[i][k] == Integer.MAX_VALUE || dist[k][j] == Integer.MAX_VALUE ) continue;
                    dist[i][j] = Math.min(dist[i][j],dist[i][k] + dist[k][j]);
                }
            }
        }
        int citycnt = n;
        int cityNo =-1;
        for(int city=0;city<n;city++){
            int cnt = 0;
            for(int adjCity=0;adjCity<n;adjCity++){
                if(dist[city][adjCity] <= distanceThreshold) cnt++;
            }
            if(cnt <=citycnt){
                citycnt = cnt;
                cityNo = city;
            }
        }
        return cityNo;
    }
}


// Minimum multiplications to reach end

// Given start, end, and an array arr of n numbers.
//  At each step, the start is multiplied by any number in the array 
//  and then a mod operation with 100000 is done to get the new start.



// Find the minimum steps in which the end can be achieved starting from the start.
//  If it is not possible to reach the end, then return -1.


// Example 1

// Input: arr = [2, 5, 7], start = 3, end = 30

// Output: 2

// Explanation: 

// Step 1: 3*2 = 6 % 100000 = 6 

// Step 2: 6*5 = 30 % 100000 = 30

// Therefore, in minimum 2 multiplications, we reach the end number which is treated as a destination node of a graph here.

// Example 2

// Input: arr = [3, 4, 65], start = 7, end = 66175

// Output: 4

// Explanation: 

// Step 1: 7*3 = 21 % 100000 = 21 

// Step 2: 21*3 = 6 % 100000 = 63 

// Step 3: 63*65 = 4095 % 100000 = 4095 

// Step 4: 4095*65 = 266175 % 100000 = 66175

// Therefore, in minimum 4 multiplications we reach the end number which is treated as a destination node of a graph here.

class Pair{
    int first,second;
    Pair(int first,int second){
        this.first = first;
        this.second = second;
    }
}

class Solution {
    public int minimumMultiplications(int[] arr, int start, int end) {
       Queue<Pair> q = new LinkedList<>();
       int[] dist = new int[100000];
       for(int i=0;i<100000;i++) dist[i] = (int)(1e9);
       dist[start] = 0;
       int mod = 100000;
       q.add(new Pair(start,0));
       int n = arr.length;
       while(!q.isEmpty()){
        int node = q.peek().first;
        int steps = q.peek().second;
        q.remove();
        for(int i=0;i<n;i++){
            int num = (arr[i] * node) % mod;
            if(steps+1 < dist[num]){
                dist[num] = steps +1;
                if(num == end) return steps +1;
                q.add(new Pair(num,steps+1));
            }
        }
       }
       return -1;
    }
}

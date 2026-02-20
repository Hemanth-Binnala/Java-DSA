// There are a total of N tasks, labeled from 0 to N-1. Given an array arr where arr[i] = [a, b] 
// indicates that you must take course b first if you want to take course a. Find if it is possible to finish all tasks.


// Examples:
// Input: N = 4, arr = [[1,0],[2,1],[3,2]]



// Output: True



// Explanation: It is possible to finish all the tasks in the order : 0 1 2 3.

// First, we will finish task 0. Then we will finish task 1, task 2, and task 3.

// Input: N = 4, arr = [[0,1],[3,2],[1,3],[3,0]]

// Output: False



// Explanation: It is impossible to finish all the tasks. Let’s analyze the pairs:

// For pair {0, 1} -> we need to finish task 1 first and then task 0. (order : 1 0).

// For pair{3, 2} -> we need to finish task 2 first and then task 3. (order: 2 3).

// For pair {1, 3} -> we need to finish task 3 first and then task 1. (order: 3 1).

// But for pair {3, 0} -> we need to finish task 0 first and then task 3 but task 0 requires task 1 and task 1 requires task 3. So, it is not possible to finish all the tasks.










package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public boolean canFinish(int N, int[][] arr) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i=0;i<N;i++){
            adj.add(new ArrayList<>());
        }
        int m = arr.length;
        for(int i=0;i<m;i++){
            adj.get(arr[i][1]).add(arr[i][0]);
        }

        int[] inDegree = new int[N];
        for(int i=0;i<N;i++){
            for(int it : adj.get(i)){
                inDegree[it]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<N;i++){
            if(inDegree[i]==0){
                q.add(i);
            }
        }

        List<Integer> topo = new ArrayList<Integer>();
        while(!q.isEmpty()){
            int node = q.peek();
            q.remove();
            topo.add(node);
            for(int it : adj.get(node)){
                inDegree[it]--;
                if(inDegree[it]==0){
                    q.add(it);
                }
            }
        } 
        if(topo.size() == N) return true;
        return false;
    }
    
}


class Main {
    public static void main(String[] args) {
       int numCourses = 2;
       int[][] prerequisites ={{1,0},{0,1}};

        Solution sol = new Solution();
        System.out.println(sol.course(numCourses,prerequisites));
    }
}

///////////////////////////////DFS////////////////////////////////

class Solution{
    public boolean course(int numCourses,int[][] prerequisites){
        int l = prerequisites.length;
        int[] vis = new int[numCourses];
        List<Integer>[] graph = new ArrayList[numCourses];
        for(int i=0;i< numCourses;i++) graph[i] = new ArrayList<>();
        for(int[] edge : prerequisites){
            int cour = edge[0];
            int pre = edge[1];
            graph[pre].add(cour);
        }
        Stack<Integer> st = new Stack<Integer>();
        for(int i=0;i<l;i++){
            vis[i] = 0;
        }
        for(int i=0;i<l;i++){
            if(vis[i] == 0){
                if(dfs(vis,i,graph,st)) return false;
            }
        }
       return true;
}
    public boolean dfs(int[] vis,int node,List<Integer>[] graph,Stack<Integer> st){
        vis[node] = 1;
        for(Integer it : graph[node]){
            if(vis[it] == 0){
                if(dfs(vis,it,graph,st)) return true;
            }
            else if(vis[it] == 1){
                return true;
            }
        }
        vis[node] = 2;
        return false;
    }
}
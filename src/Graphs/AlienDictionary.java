// Given a sorted dictionary of an alien language having N words and K starting alphabets of a standard dictionary.
//  Find the order of characters in the alien language.

// There may be multiple valid orders for a particular test case, thus you may return any valid order as a string.
//  The output will be True if the order returned by the function is correct, else False denoting an incorrect order.
//   If the given arrangement of words is inconsistent with any possible letter ordering, return an empty string "".


// Examples:

// Input: N = 5, K = 4, dict = ["baa","abcd","abca","cab","cad"]



// Output: b d a c



// Explanation: 

// We will analyze every consecutive pair to find out the order of the characters.

// The pair “baa” and “abcd” suggests ‘b’ appears before ‘a’ in the alien dictionary.

// The pair “abcd” and “abca” suggests ‘d’ appears before ‘a’ in the alien dictionary.

// The pair “abca” and “cab” suggests ‘a’ appears before ‘c’ in the alien dictionary.

// The pair “cab” and “cad” suggests ‘b’ appears before ‘d’ in the alien dictionary.

// So, [‘b’, ‘d’, ‘a’, ‘c’] is a valid ordering.

// Input: N = 3, K = 3, dict = ["caa","aaa","aab"]



// Output: c a b



// Explanation: Similarly, if we analyze the consecutive pair 

// for this example, we will figure out [‘c’, ‘a’, ‘b’] is 

// a valid ordering.



package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {

    public List<Integer> toposort(int V, List<List<Integer>> adj){
        int[] inDegree = new int[V];
        for(int i=0;i<V;i++){
            for(int it : adj.get(i)){
                inDegree[it]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<V;i++){
            if(inDegree[i] == 0){
                q.add(i);
            }
        }
        List<Integer> topo = new ArrayList<>();
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
        return topo;
    }
    public String findOrder(String [] dict, int N, int K) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0;i<K;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0; i<N-1;i++){
            String s1 = dict[i];
            String s2 = dict[i+1];
            int len = Math.min(s1.length(),s2.length());
            for(int p=0;p<len;p++){
                if(s1.charAt(p) != s2.charAt(p)){
                    adj.get(s1.charAt(p) - 'a').add(s2.charAt(p) - 'a');
                    break;
                }
            }
        }
        List<Integer> topo = toposort(K,adj);
        String S = "";
        for(int it : topo){
            S += (char)(it + 'a');
        }
        return S;

    }
}
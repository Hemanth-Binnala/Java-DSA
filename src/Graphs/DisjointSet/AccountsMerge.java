// Accounts merge

// Given a list of accounts where each element account [i] is a list of strings, where the first 
// element account [i][0] is a name, and the rest of the elements are emails representing emails of the account.



// Now, merge these accounts. Two accounts definitely belong to the same person
//  if there is some common email to both accounts. Note that even if two accounts
//   have the same name, they may belong to different people as people could have the same name. 
//   A person can have any number of accounts initially, but all of their accounts definitely have the same name.



// After merging the accounts, return the accounts in the following format: the first element 
// of each account is the name, and the rest of the elements are emails in sorted order.


// Example 1

// Input: N = 4,

// accounts =

// [["John","johnsmith@mail.com","john_newyork@mail.com"],

// ["John","johnsmith@mail.com","john00@mail.com"],

// ["Mary","mary@mail.com"],

// ["John","johnnybravo@mail.com"]]



// Output: [["John","john00@mail.com","john_newyork@mail.com", "johnsmith@mail.com"],

// ["Mary","mary@mail.com"],

// ["John","johnnybravo@mail.com"]]



// Explanation: The first and the second John are the same person as they have a common
//  email. But the third Mary and fourth John are not the same as they do not have any common email. 
//  The result can be in any order but the emails must be in sorted order. The following is also a valid result:

// [['Mary', 'mary@mail.com'],

// ['John', 'johnnybravo@mail.com'],

// ['John', 'john00@mail.com' , 'john_newyork@mail.com', 'johnsmith@mail.com' ]]

// Example 2

// Input: N = 6,

// accounts =

// [["John","j1@com","j2@com","j3@com"],

// ["John","j4@com"],

// ["Raj",”r1@com”, “r2@com”],

// ["John","j1@com","j5@com"],

// ["Raj",”r2@com”, “r3@com”],

// ["Mary","m1@com"]]



// Output: [["John","j1@com","j2@com","j3@com","j5@com"],

// ["John","j4@com"],

// ["Raj",”r1@com”, “r2@com”, “r3@com”],

// ["Mary","m1@com"]]



// Explanation: The first and the fourth John are the same person here as they have a common email.
//  And the third and the fifth Raj are also the same person. So, the same accounts are merged.











class Solution {
    static List<List<String>> accountsMerge(List<List<String>> accounts) {
       int n = accounts.size();
       Disjoint ds = new Disjoint(n);
       HashMap<String,Integer> mapMailNode = new HashMap<String,Integer>();
       for(int i=0;i<n;i++){
        for(int j=1;j<accounts.get(i).size();j++){
            String mail = accounts.get(i).get(j);
            if(mapMailNode.containsKey(mail) == false){
                mapMailNode.put(mail,i);
            }
            else{
                ds.unionBySize(i,mapMailNode.get(mail));
            }
        }
       }
       ArrayList<String>[] mergedMail = new ArrayList[n];
       for(int i=0;i<n;i++) mergedMail[i] = new ArrayList<String>();
       for(Map.Entry<String, Integer> it : mapMailNode.entrySet()){
        String mail = it.getKey();
        int node = ds.findParent(it.getValue());
        mergedMail[node].add(mail);
       }
       List<List<String>> ans = new ArrayList<>();
       for(int i=0;i<n;i++){
        if(mergedMail[i].size() == 0) continue;
        Collections.sort(mergedMail[i]);
        List<String> temp = new ArrayList<>();
        temp.add(accounts.get(i).get(0));
        for(String mail : mergedMail[i]){
            temp.add(mail);
        }
        ans.add(temp);
       }
       return ans;
    }
}

class Disjoint{
    int[] parent;
    int[] size;
    public Disjoint(int n){
        parent = new int[n];
        size = new int[n];
        for(int i=0;i<n;i++){
            parent[i] = i;
            size[i] = 1;
        }
    }
    public int findParent(int node){
        if(node == parent[node]) return node;
         parent[node] = findParent(parent[node]);
         return parent[node];
    }
    public void unionBySize(int u, int v){
        int pu = findParent(u);
        int pv = findParent(v);
        if(pu == pv) return ;
        if(size[pu] < size[pv]){
            parent[pu] = pv;
            size[pv] += size[pu];
        }
        else{
            parent[pv]  = pu;
            size[pu] += size[pv];
        }
    }
}
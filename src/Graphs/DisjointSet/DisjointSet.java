// Disjoint Set
// Subscribe to TUF+

// Hints
// Company
// Design a disjoint set (also called union-find) data structure that supports the following operations:



// DisjointSet(int n) initializes the disjoint set with n elements.

// void unionByRank(int u, int v) merges the sets containing u and v using the rank heuristic.

// void unionBySize(int u, int v) merges the sets containing u and v using the size heuristic.

// bool find(int u, int v) checks if the elements u and v are in the same set and returns true if they are, otherwise false.


// Example 1

// Input:

// ["DisjointSet", "unionByRank", "unionBySize", "find", "find"]

// [[5], [0, 1], [2, 3], [0, 1], [0, 3]]



// Output:

// [null, null, null, true, false]



// Explanation:

// DisjointSet ds = new DisjointSet(5); // Initialize a disjoint set with 5 elements

// ds.unionByRank(0, 1); // Merge sets containing 0 and 1 using rank

// ds.unionBySize(2, 3); // Merge sets containing 2 and 3 using size

// ds.find(0, 1); // Returns true as 0 and 1 are in the same set

// ds.find(0, 3); // Returns false as 0 and 3 are not in the same set

// Example 2

// Input:

// ["DisjointSet", "unionBySize", "unionBySize", "find", "find"]

// [[3], [0, 1], [1, 2], [0, 2], [0, 1]]



// Output:

// [null, null, null, true, true]



// Explanation:

// DisjointSet ds = new DisjointSet(3); // Initialize a disjoint set with 3 elements

// ds.unionBySize(0, 1); // Merge sets containing 0 and 1 using size

// ds.unionBySize(1, 2); // Merge sets containing 1 and 2 using rank

// ds.find(0, 2); // Returns true as 0 and 2 are in the same set

// ds.find(0, 1); // Returns true as 0 and 1 are in the same set

class DisjointSet {
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    public DisjointSet(int n) {
        for(int i=0;i<=n;i++){
            rank.add(0);
            parent.add(i);
            size.add(1);
        }
    }

    public int findParent(int node){
        if(node == parent.get(node))
        return node;
        int ulp = findParent(parent.get(node));
        parent.set(node,ulp);
        return parent.get(node);    }


    public boolean find(int u, int v) {
        return findParent(u) == findParent(v);
    }

    public void unionByRank(int u, int v) {
        int pu = findParent(u);
        int pv = findParent(v);

        if(pu == pv) return;
        if(rank.get(pu) < rank.get(pv)){
            parent.set(pu,pv);
        }
        else if(rank.get(pv) < rank.get(pu)){
            parent.set(pv,pu);
        }
        else{
            parent.set(pu,pv);
            rank.set(pu,rank.get(pu) + 1);
        }
    }

    public void unionBySize(int u, int v) {
        int pu = findParent(u);
        int pv = findParent(v);

        if(pu == pv) return;
        if(size.get(pu) < size.get(pv)){
            parent.set(pu,pv);
            size.set(pv,size.get(u) + size.get(v));
        } 
        else{
            parent.set(pv,pu);
            size.set(pu,size.get(pu) + size.get(pv));
        }
    }
}

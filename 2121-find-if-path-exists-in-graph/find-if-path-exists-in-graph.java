class Solution {

    public int find(int a, int parent[]){
        return parent[a] = (a == parent[a])? a: find(parent[a], parent);
    }

    public void unite(int a, int b, int parent[], int rank[]){
        a = find(a, parent);
        b = find(b, parent);

        if(a == b) return;

        if(rank[a] > rank[b]){
            parent[b] = a;
        }
        else if(rank[a] < rank[b]){
            parent[a] = b;
        }
        else{
            parent[b] = a;
            rank[a]++;
        }
    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        int parent[] = new int[n];
        int rank[] = new int[n];
        for(int i=0; i<n; i++) parent[i] = i;

        for(int edge[]: edges){
            unite(edge[0], edge[1], parent, rank);
        }

        return find(source, parent) == find(destination, parent);
    }
}
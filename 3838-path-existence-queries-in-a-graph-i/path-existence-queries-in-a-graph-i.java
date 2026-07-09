class Solution {

    public int find(int a, int parent[]){
        return (parent[a] == a)? a: find(parent[a], parent);
    }

    public void unite(int a, int b, int rank[], int parent[]){
        if(rank[a] > rank[b]){
            parent[b] = a;
        }
        else if(rank[b] > rank[a]){
            parent[a] = b;
        }
        else{
            parent[b] = a;
            rank[a]++;
        }
    }

    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int parent[] = new int[n];
        for(int i=0; i<n; i++) parent[i] = i;
        int rank[] = new int[n];

        for(int i=1; i<nums.length; i++){
            if(nums[i]-nums[i-1] <= maxDiff){
                int a = find(i, parent);
                int b = find(i - 1, parent);

                if(a != b) unite(a, b, rank, parent);
            }
        }

        boolean ans[] = new boolean[queries.length];
        int i = 0;

        for(int qu[]: queries){
            int a = qu[0];
            int b = qu[1];

            if(find(a, parent) == find(b, parent)) ans[i] = true;
            i++;
        }

        return ans;
    }
}
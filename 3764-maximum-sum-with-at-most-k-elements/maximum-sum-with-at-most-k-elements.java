class Solution {
    public long maxSum(int[][] grid, int[] limits, int k) {
        int n = grid.length;
        int m = grid[0].length;

        for(int num[]: grid){
            Arrays.sort(num);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0; i<n; i++){
            for(int j=m-1; j>=Math.max(0, m-limits[i]); j--){
                pq.add(grid[i][j]);
                if(pq.size() > k) pq.poll();
            }
        }

        long ans = 0;
        while(pq.size() > 0){
            ans += (long)(pq.poll());
        }
        return ans;
    }
}
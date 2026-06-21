class Solution {
    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;
        for(int i=0; i<n; i++){
            boolean visited[] = new boolean[n];
            boolean forward = (nums[i]>0)? true: false;
            visited[i] = true;
            int idx = i;
            while(true){
                if((nums[idx] > 0) != forward) break;

                int nxt = ((idx + nums[idx]) % n + n) % n;
                if((nums[nxt] > 0) != forward) break;

                if(visited[nxt] && nxt != idx) return true;
                if(nxt == idx) break;

                visited[nxt] = true;
                idx = nxt;
            }
        }

        return false;
    }
}
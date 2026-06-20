class Solution {
    public int maxBuilding(int n, int[][] num) {
        Arrays.sort(num, (a, b)->a[0]-b[0]);
        int ans = 0;

        int nums[][] = new int[num.length+2][2];
        nums[0] = new int[]{1, 0};
        nums[nums.length - 1] = new int[]{n, n - 1};

        for(int i=1; i<nums.length-1; i++){
            nums[i] = num[i-1];
        }

        for(int i = 1; i < nums.length; i++){
            int dist = nums[i][0] - nums[i-1][0];
            nums[i][1] = Math.min(nums[i][1], nums[i-1][1] + dist);
        }

        for(int i = nums.length - 2; i >= 0; i--){
            int dist = nums[i + 1][0] - nums[i][0];
            nums[i][1] = Math.min(nums[i][1], nums[i + 1][1] + dist);
        }

        if(num.length == 0) return n-1;

        for(int i=0; i<nums.length-1; i++){
            int[] fir = nums[i];
            int[] sec = nums[i+1];

            int diff = sec[0]-fir[0];

            int peak = (fir[1] + sec[1] + diff) / 2;
            ans = Math.max(ans, peak);
        }

        return ans;
    }
}
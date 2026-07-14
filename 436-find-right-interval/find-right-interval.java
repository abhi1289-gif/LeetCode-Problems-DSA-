class Solution {

    public int travel(int nums[][], int a){
        int i = 0;
        int j = nums.length-1;
        int ans = -1;

        while(i <= j){
            int mid = i + (j-i)/2;

            if(nums[mid][0] >= a){
                ans = mid;
                j = mid-1;
            }
            else{
                i = mid+1;
            }
        }

        return ans;
    }

    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;

        int nums[][] = new int[n][3];

        for(int i=0; i<n; i++){
            nums[i][0] = intervals[i][0];
            nums[i][1] = intervals[i][1];
            nums[i][2] = i;
        }

        Arrays.sort(nums, (a, b)->a[0]-b[0]);

        int ans[] = new int[n];

        for(int i=0; i<n; i++){
            int a = travel(nums, nums[i][1]);
            if(a == -1) ans[nums[i][2]] = -1;
            else ans[nums[i][2]] = nums[a][2];
        }

        return ans;
    }
}
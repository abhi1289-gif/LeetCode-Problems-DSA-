class Solution {

    public boolean isPossible(int nums[], int day, int m, int k){
        // find can we make m groups with k neighbours
        boolean canVisit[] = new boolean[nums.length];

        for(int i=0; i<nums.length; i++){
            if(nums[i] <= day) canVisit[i] = true;
        }

        int i = 0;
        int grp = 0;

        while(i < nums.length){
            if(canVisit[i]){
                int a = k;
                while(a>0 && i<nums.length && canVisit[i]){
                    a--;
                    i++;
                }
                if(a == 0) grp++;
            }
            else i++;
        }
        if(grp >= m) return true;

        return false;
    }

    int find(int[] sorted, int[] nums, int m, int k){
        int i = 0;
        int j = sorted.length-1;

        int ans = -1;

        while(i <= j){
            int mid = i + (j-i)/2;

            if(isPossible(nums, sorted[mid], m, k)){
                ans = sorted[mid];
                j = mid-1;
            }
            else{
                i = mid+1;
            }
        }
        return ans;
    }

    public int minDays(int[] nums, int m, int k) {
        if(m*k > nums.length) return -1;

        int[] copy = nums.clone();
        Arrays.sort(copy);
        return find(copy, nums, m, k);
    }
}
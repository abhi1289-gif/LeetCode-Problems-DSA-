class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        List<Integer> arr = new ArrayList<>();
        int i = 1;
        while(i < nums.length-1){
            int j = i;
            while(j < nums.length-1 && nums[j] - nums[j-1] == nums[j+1] - nums[j]){
                j++;
            }
            if (j > i) {
                arr.add(j + 1 - (i - 1));
            }
            
            i = j+1;
        }
        int ans = 0;

        for(int num: arr){
            ans += (num-1)*(num-2)/2;
        }

        return ans;
    }
}
class Solution {
    public boolean checkPossibility(int[] nums) {
        // Stack<Integer> st = new Stack<>();

        // for(int num: nums){
        //     while(st.size() > 0 && num < st.peek()) st.pop();
        //     st.add(num);
        // }

        // return (nums.length - st.size() < 2)? true: false;

        int vio = 0;

        for(int i=0; i<nums.length-1; i++){
            if(nums[i]> nums[i+1]){
                vio++;

                if(vio>1) return false;

                if(i == 0 || nums[i+1] >= nums[i-1]){
                    nums[i] = nums[i+1];
                }
                else{
                    nums[i+1] = nums[i];
                }
            }
        }
        return true;

    }
}
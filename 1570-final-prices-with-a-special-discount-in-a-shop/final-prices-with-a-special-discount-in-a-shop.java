class Solution {
    public int[] finalPrices(int[] nums) {
        Stack<Integer> st = new Stack<>();

        int ans[] = new int[nums.length];

        for(int i=nums.length-1; i>=0; i--){
            while(st.size() > 0 && st.peek() > nums[i]) st.pop();
            if(st.size()>0) ans[i] = nums[i] - st.peek();
            else ans[i] = nums[i];

            st.add(nums[i]);
        }

        return ans;
    }
}
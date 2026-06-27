class Solution {
    public List<String> buildArray(int[] nums, int n) {
        List<String> ans = new ArrayList<>();
        String push = "Push";
        String pop = "Pop";

        for(int i=1; i<nums[0]; i++){
            ans.add(push);
            ans.add(pop);
        }
        
        int prev = nums[0];
        for(int i=0; i<nums.length; i++){
            int curr = nums[i];

            int diff = curr-prev-1;
            while(diff > 0){
                diff--;
                ans.add(push);
                ans.add(pop);
            }

            prev = curr;

            ans.add(push);
        }
        return ans;
    }
}
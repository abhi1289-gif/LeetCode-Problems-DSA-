class Solution {
    public int maximumSum(int[] nums) {
        List<Integer> zero = new ArrayList<>();
        List<Integer> one = new ArrayList<>();
        List<Integer> two = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0, j = nums.length - 1; i < j; i++, j--) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        for(int i=0; i<nums.length; i++){
            if(nums[i]%3 == 0) zero.add(nums[i]);
            else if(nums[i]%3 == 1) one.add(nums[i]);
            else two.add(nums[i]);
        }
        int ans = 0;
        
        if(zero.size()>2){
            int sum = 0;
            for(int i=0; i<3; i++){
                sum += zero.get(i);
            }
            ans = Math.max(ans, sum);
        }
        
        if(one.size()>2){
            int sum = 0;
            for(int i=0; i<3; i++){
                sum += one.get(i);
            }
            ans = Math.max(ans, sum);
        }
        
        if(two.size()>2){
            int sum = 0;
            for(int i=0; i<3; i++){
                sum += two.get(i);
            }
            ans = Math.max(ans, sum);
        }

        if(zero.size() > 0 && one.size() > 0 && two.size() > 0){
            ans = Math.max(ans, zero.get(0) + one.get(0) + two.get(0));
        }

        return ans;
    }
}
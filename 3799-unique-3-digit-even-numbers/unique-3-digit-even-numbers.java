class Solution {
    public int totalNumbers(int[] nums) {

        HashSet<Integer> ans = new HashSet<>();
        
        for(int i=0; i<nums.length-2; i++){
            for(int j = i+1; j<nums.length-1; j++){
                for(int k=j+1; k<nums.length; k++){
                    int temp = nums[i]*100 + nums[j]*10 + nums[k];
                    if(temp%2 == 0 && temp-100 >= 0) ans.add(temp);

                    temp = nums[i]*100 + nums[k]*10 + nums[j];
                    if(temp%2 == 0 && temp-100 >= 0) ans.add(temp);

                    temp = nums[j]*100 + nums[i]*10 + nums[k];
                    if(temp%2 == 0 && temp-100 >= 0) ans.add(temp);

                    temp = nums[j]*100 + nums[k]*10 + nums[i];
                    if(temp%2 == 0 && temp-100 >= 0) ans.add(temp);

                    temp = nums[k]*100 + nums[i]*10 + nums[j];
                    if(temp%2 == 0 && temp-100 >= 0) ans.add(temp);

                    temp = nums[k]*100 + nums[j]*10 + nums[i];
                    if(temp%2 == 0 && temp-100 >= 0) ans.add(temp);
                }
            }
        }

        return ans.size();
    }
}
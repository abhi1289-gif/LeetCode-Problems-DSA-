class Solution {
    public int maxProduct(int[] nums) {
        int a = Integer.MIN_VALUE;
        int b = Integer.MIN_VALUE;
        
        for(int num: nums){
            if(num > b){
                a = b;
                b = num;
            }
            else{
                a = Math.max(a, num);
            }
        }

        return (a-1)*(b-1);
    }
}
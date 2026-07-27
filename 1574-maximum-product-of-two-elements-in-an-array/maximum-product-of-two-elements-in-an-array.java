class Solution {
    public int maxProduct(int[] nums) {
        int a = 0;
        int b = 0;

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
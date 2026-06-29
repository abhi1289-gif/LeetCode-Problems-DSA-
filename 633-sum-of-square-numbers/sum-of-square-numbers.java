class Solution {
    public boolean judgeSquareSum(int c) {
        int i = 0;
        int j = (int)Math.sqrt(c);

        while(i <= j){
            long sum = (long)i*i + (long)j*j;
            
            if(sum == c) return true;

            if(sum > c){
                j--;
            }
            else{
                i++;
            }
        }

        return false;
    }
}
class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if(sum/9 > num) return "";
        StringBuilder ans = new StringBuilder();

        while(sum >= 9 && num > 0){
            num--;
            sum -= 9;
            ans.append('9');
        }
        if(num != 0 && sum > 0 && sum < 9){
            ans.append(String.valueOf(sum));
            num--;
            sum = 0;
        }

        if(num == 0 && sum != 0) return "";
        
        while(num > 0){
            ans.append('0');
            num--;
        }
        return ans.toString();
    }
}
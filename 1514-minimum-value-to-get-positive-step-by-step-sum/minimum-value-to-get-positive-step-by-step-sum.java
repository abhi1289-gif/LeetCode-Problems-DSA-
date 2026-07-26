class Solution {
    public int minStartValue(int[] nums) {
        int a = 0;
        while(true){
            int ans = a+1;
            a++;
            boolean flag = true;
            for(int num: nums){
                ans += num;
                if(ans < 1){
                    flag = false;
                    break;
                }
            }
            if(flag) return a;
        }
    }
}
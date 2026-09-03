class Solution {
    public boolean uniformArray(int[] nums) {
        int minne = Integer.MAX_VALUE;
        int minno = Integer.MAX_VALUE;

        for(int num: nums){
            if(num%2 != 0){
                minno = Math.min(minno, num);
            }
            else{
                minne = Math.min(minne, num);
            }
        }

        if(minne == Integer.MAX_VALUE || minno == Integer.MAX_VALUE) return true;

        return  minno < minne;
    }
}
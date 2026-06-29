class Solution {
    public int firstMissingPositive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int maxx = 0;
        for(int num: nums){
            maxx = Math.max(num, maxx);
            set.add(num);
        }

        for(int i=1; i<=maxx; i++){
            if(!set.contains(i)) return i;
        }

        return maxx+1;
    }
}
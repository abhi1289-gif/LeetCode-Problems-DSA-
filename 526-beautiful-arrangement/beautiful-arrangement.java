class Solution {

    int ans;

    public void travel(List<Integer> nums, boolean used[], int n){
        if(nums.size() == n+1){
            ans++;
            return;
        }

        for(int i=1; i<=n; i++){
            if(used[i]) continue;

            if(nums.size() %i == 0 || i%nums.size() == 0){
                used[i] = true;
                nums.add(i);
                travel(nums, used, n);
                nums.remove(nums.size()-1);
                used[i] = false;
            }
        }
    }

    public int countArrangement(int n) {
        ans = 0;
        List<Integer> nums = new ArrayList<>();
        nums.add(0);
        boolean used[] = new boolean[n+1];
        travel(nums, used, n);
        return ans;
    }
}
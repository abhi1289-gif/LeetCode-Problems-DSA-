class Solution {
    public List<List<Integer>> filterOccupiedIntervals(int[][] nums, int s, int e) {
        Arrays.sort(nums, (a, b)-> a[0]-b[0]);
        List<List<Integer>> ans = new ArrayList<>();

        int start = nums[0][0];
        int end = nums[0][1];

        for(int i=1; i<nums.length; i++){
            int num[] = nums[i];

            if(end+1 >= num[0]){
                end = Math.max(end, num[1]); 
            }
            else{
                if(start > e || end < s){
                    ans.add(Arrays.asList(start, end));
                }
                else{
                    if(start < s){
                        ans.add(Arrays.asList(start, s-1));
                    }
                    if(end > e){
                        ans.add(Arrays.asList(e+1, end));
                    }
                }
                start = num[0];
                end = num[1];
            }
        }

        if(start > e || end < s){
            ans.add(Arrays.asList(start, end));
        }
        else{
            if(start < s){
                ans.add(Arrays.asList(start, s-1));
            }
            if(end > e){
                ans.add(Arrays.asList(e+1, end));
            }
        }

        return ans;
    }
}
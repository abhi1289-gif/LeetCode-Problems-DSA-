class Solution {
    public long dividePlayers(int[] nums) {
        long sum = 0;
        for(int num: nums) sum += (long)num;
        int n = nums.length/2;
        if(sum%n != 0) return -1;
        sum = sum/n;

        HashMap<Integer, Integer> mapp = new HashMap<>();
        List<int[]> res = new ArrayList<>();

        for(int num: nums){
            int req = (int)(sum-num);
            if(mapp.containsKey(req)){
                mapp.put(req, mapp.get(req)-1);
                if(mapp.get(req) == 0) mapp.remove(req);
                res.add(new int[]{num, req});
            }
            else{
                mapp.put(num, mapp.getOrDefault(num, 0)+1);
            }
        }

        if(mapp.size() > 0) return -1;

        long ans = 0;
        for(int num[]: res){
            ans += (long)num[0]*num[1];
        }

        return ans;
    }
}
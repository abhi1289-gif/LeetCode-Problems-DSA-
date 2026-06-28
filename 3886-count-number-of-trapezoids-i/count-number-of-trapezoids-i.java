class Solution {
    long mod = 1000000007;

    public int countTrapezoids(int[][] points) {
        HashMap<Integer, Integer> mapp = new HashMap<>();

        for(int point[]: points){
            int y = point[1];
            mapp.put(y, mapp.getOrDefault(y, 0)+1);
        }

        long ans = 0;
        List<Integer> nums = new ArrayList<>();

        long total = 0;

        for(int val: mapp.values()){
            if(val<2) continue;
            nums.add(val);
            total += 1L * val * (val-1) / 2;
        }

        for(int i=0; i<nums.size(); i++){
            int a = nums.get(i);

            long ways = (1L * a * (a - 1) / 2) % mod;
            total -= ways;
            ans = (ans + total*ways)%mod;
        }

        return (int)ans;
    }
}
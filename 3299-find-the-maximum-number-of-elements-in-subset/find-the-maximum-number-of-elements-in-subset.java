class Solution {
    public int maximumLength(int[] nums) {
        if(nums.length < 3) return 1;
        HashMap<Integer, Integer> mapp = new HashMap<>();
        for(int num: nums){
            mapp.put(num, mapp.getOrDefault(num, 0)+1);
        }
        int ans = 1;

        for(int key: mapp.keySet()){
            int a = key;
            if(mapp.get(a) == 1) continue;
            if(key == 1){
                int count = mapp.get(1);
                if(count%2==0) ans = Math.max(ans, count-1);
                else ans = Math.max(ans, count);
                continue;
            }
            int len = 0;
            boolean present = true;

            while(mapp.containsKey(a) && mapp.get(a) >= 2){
                a = a*a;
                len++;
                if(!mapp.containsKey(a)) present = false;
            }

            if(present) ans = Math.max(ans, len*2+1);
            else ans = Math.max(ans, len*2-1);
        }

        return ans;
    }
}
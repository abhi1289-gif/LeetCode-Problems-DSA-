class Solution {
    public List<List<Integer>> groupThePeople(int[] nums) {
        TreeMap<Integer, List<Integer>> mapp = new TreeMap<>();

        for(int i=0; i<nums.length; i++){
            int a = nums[i];
            if(!mapp.containsKey(a)) mapp.put(a, new ArrayList<>());
            mapp.get(a).add(i);
        }

        List<List<Integer>> ans = new ArrayList<>();

        for(var mp: mapp.entrySet()){
            int a = mp.getKey();
            List<Integer> temp = mp.getValue();

            int p = 0;

            while (p < temp.size()) {
                List<Integer> t = new ArrayList<>();

                for (int i = p; i < p + a; i++) {
                    t.add(temp.get(i));
                }

                ans.add(t);
                p += a;
            }
        }

        return ans;
    }
}
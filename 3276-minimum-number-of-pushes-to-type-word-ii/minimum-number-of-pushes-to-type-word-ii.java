class Solution {
    public int minimumPushes(String word) {
        HashMap<Character, Integer> mapp = new HashMap<>();
        for(char ch: word.toCharArray()) mapp.put(ch, mapp.getOrDefault(ch, 0)+1);

        List<Integer> nums = new ArrayList<>();
        for(char key: mapp.keySet()){
           nums.add(mapp.get(key)); 
        }

        Collections.sort(nums, (a, b)->b-a);

        int ans = 0;
        int t = 0;
        int a = 1;

        for(int num: nums){
            ans += a*num;
            t++;
            
            if(t == 8){
                a++;
                t = 0;
            }
        }

        return ans;
    }  
}
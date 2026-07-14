class Solution {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int nums[] = new int[words.length];
        HashMap<Character, Integer> mapp = new HashMap<>();

        for(int i=0; i<words.length; i++){
            String curr = words[i];
            mapp.clear();
            mapp.put(curr.charAt(0), 1);
            char maxx = curr.charAt(0);

            for(int j=1; j<curr.length(); j++){
                char ch = curr.charAt(j);
                mapp.put(ch, mapp.getOrDefault(ch, 0) + 1);
                if(maxx > ch){
                    maxx = ch;
                }
            }
            nums[i] = mapp.get(maxx);
        }

        int ans[] = new int[queries.length];

        for(int i=0; i<queries.length; i++){
            String curr = queries[i];
            mapp.clear();
            mapp.put(curr.charAt(0), 1);
            char maxx = curr.charAt(0);

            for(int j=1; j<curr.length(); j++){
                char ch = curr.charAt(j);
                mapp.put(ch, mapp.getOrDefault(ch, 0) + 1);
                if(maxx > ch){
                    maxx = ch;
                }
            }
            int a = mapp.get(maxx);

            int temp = 0;

            for(int j=0; j<nums.length; j++){
                if(a < nums[j]) temp++;
            }

            ans[i] = temp;
        }

        return ans;
    }
}
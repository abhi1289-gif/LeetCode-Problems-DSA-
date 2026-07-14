class Solution {

    public int travel(int nums[], int a){
        int i = 0;
        int j = nums.length-1;
        int ans = nums.length;

        while(i <= j){
            int mid = i + (j-i)/2;

            if(nums[mid]<=a){
                i = mid+1;
            }
            else{
                ans = mid;
                j = mid-1;
            }
        }

        return nums.length-ans;
    }

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

        Arrays.sort(nums);

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

            ans[i] = travel(nums, a);
        }

        return ans;
    }
}
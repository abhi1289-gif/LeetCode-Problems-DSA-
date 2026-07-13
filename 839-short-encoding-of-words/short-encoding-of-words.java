class Solution {
    public int minimumLengthEncoding(String[] words) {
        List<String> nums = new ArrayList<>();
        Arrays.sort(words, (a, b)-> b.length() - a.length());

        for(int i=0; i<words.length; i++) nums.add(words[i]);

        for(int i=0; i<nums.size(); i++){
            String num = nums.get(i);
            for(int j=i+1; j<nums.size(); j++){
                if (num.endsWith(nums.get(j))) {
                    nums.remove(j);
                    j--;
                }
            }
        }

        int ans = 0;
        for(String s: nums){
            ans += s.length() + 1;
        }

        return ans;
    }
}
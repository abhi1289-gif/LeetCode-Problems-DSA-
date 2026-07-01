class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        if(s.length() < p.length()) return ans;
        int nums[] = new int[26];
        int arr[] = new int[26];

        for(char ch: p.toCharArray()){
            arr[(int)(ch-'a')]++;
        }

        for(int i=0; i<p.length(); i++){
            nums[(int)(s.charAt(i)-'a')]++;
        }

        boolean fir = true;

        for(int i=0; i<26; i++){
            if(nums[i] != arr[i]){
                fir = false;
                break;
            }
        }

        if(fir) ans.add(0);

        int a = 0;
        for(int i=p.length(); i<s.length(); i++){
            nums[(int)(s.charAt(i)-'a')]++;
            nums[(int)(s.charAt(a++)-'a')]--;

            boolean present = true;

            for(int j=0; j<26; j++){
                if(nums[j] != arr[j]){
                    present = false;
                    break;
                }
            }

            if(present) ans.add(a);
        }

        return ans;
    }
}
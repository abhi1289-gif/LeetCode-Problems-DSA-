class Solution {

    public String findMin(String a, String b){
        if(a.length() > b.length()) return b;
        else if(a.length() < b.length()) return a;

        for(int i=0; i<a.length(); i++){
            if(a.charAt(i) < b.charAt(i)) return a;
            else if(a.charAt(i) > b.charAt(i)) return b;
        }

        return a;
    }

    public String shortestBeautifulSubstring(String s, int k) {
        String ans = "";
        int j = 0;
        int temp = 0;

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '1') temp++;
            while(temp>k){
                if(s.charAt(j) == '1') temp--;
                j++;
            }

            if(temp == k){
                while (s.charAt(j) == '0') j++;

                if(ans.length() == 0) ans = s.substring(j, i+1);
                
                else{
                    String a = s.substring(j, i+1);
                    ans = findMin(ans, a);
                }
            }
        }

        return ans;
    }
}
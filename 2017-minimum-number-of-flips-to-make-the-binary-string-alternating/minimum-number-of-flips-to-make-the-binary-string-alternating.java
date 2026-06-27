class Solution {
    public int minFlips(String a) {
        if(a.length() < 3){
            if(a.length() == 1) return 0;
            if(a.charAt(0) != a.charAt(1)) return 0;
            return 1;
        }

        int n = a.length();

        StringBuilder s = new StringBuilder(a);
        s.append(a);

        StringBuilder num = new StringBuilder();
        StringBuilder arr = new StringBuilder();
        num.append('0');
        arr.append('1');

        for(int i=0; i<s.length(); i++){
            if(num.charAt(num.length()-1) == '0'){
                num.append('1');
                arr.append('0');
            }
            else{
                num.append('0');
                arr.append('1');
            }
        }

        int fir = 0;
        int sec = 0;
        
        for(int i=0; i<n; i++){
            if(num.charAt(i) != s.charAt(i)) fir++;
            if(arr.charAt(i) != s.charAt(i)) sec++;
        }

        int ans = Math.min(fir, sec);

        for(int i=n; i<s.length(); i++){
            int prev = i-n;

            if(num.charAt(prev) != s.charAt(prev)) fir--;
            if(arr.charAt(prev) != s.charAt(prev)) sec--;

            if(num.charAt(i) != s.charAt(i)) fir++;
            if(arr.charAt(i) != s.charAt(i)) sec++;

            ans = Math.min(fir, Math.min(ans, sec));

        }

        return ans;
    }
}
class Solution {

    public String toBits(int n){
        StringBuilder ans = new StringBuilder();

        while(n > 0){
            if(n%2 == 0) ans.append('0');
            else ans.append('1');
            n = n/2;
        }

        return ans.reverse().toString();
    }

    public int toNum(String s){
        int two = 1;
        int ans = 0;
        for(int i = s.length()-1; i>=0; i--){
            if(s.charAt(i) == '1'){
                ans += two;
            }
            two *= 2;
        }
        return ans;
    }

    public int minimizeXor(int num1, int num2) {
        if(Integer.bitCount(num1) == Integer.bitCount(num2)) return num1;

        String s = toBits(num1);
        int diff = Integer.bitCount(num2) - Integer.bitCount(num1);

        StringBuilder temp = new StringBuilder(s);
        for(int i=0; i<diff; i++) temp.insert(0, '0');

        int i = temp.length()-1;

        if(diff < 0){
            while(i >= 0 && diff < 0){
                if(temp.charAt(i) == '0'){
                    i--;
                    continue;
                }
                else{
                    temp.setCharAt(i, '0');
                    i--;
                    diff++;
                }
            }
        }
        else{
            while(i >= 0 && diff > 0){
                if(temp.charAt(i) == '1'){
                    i--;
                    continue;
                }
                else{
                    temp.setCharAt(i, '1');
                    i--;
                    diff--;
                }
            }
        }

        int sec = toNum(temp.toString());
        return sec;
    }
}
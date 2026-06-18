class Solution {

    public String findFor4(String s){

        String nums[] = s.split("\\.", -1);
        if(nums.length != 4) return "Neither";
        
        for(String num: nums){
            if(num.length() == 0 || num.length() > 3) return "Neither";
            if(num.charAt(0) == '0' && num.length() > 1) return "Neither";
            int n = 0;
            for(int i=0; i<num.length(); i++){
                if(num.charAt(i)<'0' || num.charAt(i)>'9') return "Neither";
                n = n*10 + (int)(num.charAt(i)-'0');
            }

            if(n>255) return "Neither";
        }

        return "IPv4";
    }
    public String findFor6(String s){

        String nums[] = s.split(":", -1);
        if(nums.length != 8) return "Neither";
        
        for(String num: nums){
            if(num.length() < 1 || num.length() > 4) return "Neither";
            
            int n = 0;
            for(int i=0; i<num.length(); i++){
                if(num.charAt(i)>='0' && num.charAt(i)<='9') continue;
                else if(num.charAt(i)>='a' && num.charAt(i)<='f') continue;
                else if(num.charAt(i)>='A' && num.charAt(i)<='F') continue;
                else return "Neither";
            }
        }

        return "IPv6";
    }

    public String validIPAddress(String queryIP) {
        boolean type1 = false;
        boolean type2 = false;
        int n = queryIP.length();

        for(int i=0; i<n; i++){
            if(queryIP.charAt(i) == '.') type1 = true;
            else if(queryIP.charAt(i) == ':') type2 = true;
        }

        if(type1 && type2) return "Neither";

        String ans;

        if(type1) ans = findFor4(queryIP);
        else ans = findFor6(queryIP);

        return ans;
    }
}
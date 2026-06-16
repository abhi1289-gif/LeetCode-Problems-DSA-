class Solution {

    List<String> ans;

    public void make(String s, int i, int dots, StringBuilder str){
        if(i == s.length() && dots == 4){
            ans.add(str.substring(0, str.length()-1));
            return;
        }
        
        if(i == s.length() || dots == 4){
            return;
        }

        int len = str.length();

        str.append(s.charAt(i)).append('.');
        make(s, i+1, dots+1, str);
        str.setLength(len);

        if(i+1 < s.length() && s.charAt(i) != '0'){
            str.append(s.charAt(i)).append(s.charAt(i+1)).append('.');
            make(s, i+2, dots+1, str);
            str.setLength(len);
        }

        if(i+2 < s.length()){
            int num = (s.charAt(i)-'0')*100 + (s.charAt(i+1)-'0')*10 + (s.charAt(i+2)-'0');
            str.append(s.charAt(i)).append(s.charAt(i+1)).append(s.charAt(i+2)).append('.');
            if(num>99 && num<256) make(s, i+3, dots+1, str);
            str.setLength(len);
        }        
    }

    public List<String> restoreIpAddresses(String s) {
        ans = new ArrayList<>();
        StringBuilder a = new StringBuilder();
        make(s, 0, 0, a);
        return ans;
    }
}
class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        HashMap<String, String> mapp = new HashMap<>();

        for(List<String> temp: knowledge){
            mapp.put(temp.get(0), temp.get(1));
        }

        StringBuilder ans = new StringBuilder();

        int i = 0;

        while(i < s.length()){
            if(s.charAt(i) != '('){
                ans.append(s.charAt(i));
                i++;
            }
            else{
                i++;
                StringBuilder temp = new StringBuilder();
                while(s.charAt(i) != ')'){
                    temp.append(s.charAt(i));
                    i++;
                }
                i++;
                
                String key = temp.toString();
                if(mapp.containsKey(key)){
                    ans.append(mapp.get(key));
                }
                else{
                    ans.append('?');
                }
            }
        }

        return ans.toString();
    }
}
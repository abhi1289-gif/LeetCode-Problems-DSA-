class Solution {
    public int maximumLength(String s) {
        HashMap<String, Integer> mapp = new HashMap<>();

        for(int i=0; i<s.length(); i++){
            for(int j=i+1; j<=s.length(); j++){
                String temp = s.substring(i, j);

                boolean valid = true;

                for (int k = 1; k < temp.length(); k++) {
                    if (temp.charAt(k) != temp.charAt(0)) {
                        valid = false;
                        break;
                    }
                }

                if (valid) {
                    mapp.put(temp, mapp.getOrDefault(temp, 0) + 1);
                }

            }
        }

        int ans = -1;   

        for(String key: mapp.keySet()){
            if(mapp.get(key) >= 3) ans = Math.max(ans, key.length());
        }

        return ans;
    }
}
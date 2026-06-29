class Solution {
    public int numOfStrings(String[] patterns, String word) {
        // HashMap<String, Integer> mapp = new HashMap<>();

        // for(String p: patterns){
        //     mapp.put(p, mapp.getOrDefault(p, 0)+1);
        // }

        int ans = 0;

        // for(int i=0; i<word.length(); i++){
        //     for(int j=i; j<word.length(); j++){
        //         String a = word.substring(i, j+1);
        //         if(mapp.containsKey(a)){
        //             ans += mapp.get(a);
        //             mapp.remove(a);
        //         }
        //     }
        // }

        for(int i=0; i<patterns.length; i++){
            if(word.contains(patterns[i])){
                ans++;
            }
        }

        return ans;
    }
}
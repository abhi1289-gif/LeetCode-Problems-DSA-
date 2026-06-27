class AuthenticationManager {

    HashMap<String, Integer> mapp = new HashMap<>();
    int t = -1;

    public AuthenticationManager(int timeToLive) {
        t = timeToLive;
        mapp.clear();
    }
    
    public void generate(String tokenId, int currentTime) {
        mapp.put(tokenId, currentTime+t);
    }
    
    public void renew(String tokenId, int currentTime) {
        if(mapp.containsKey(tokenId)){
            int a = mapp.get(tokenId);
            if(currentTime < a){
                mapp.put(tokenId, currentTime+t);
            }
        }
    }
    
    public int countUnexpiredTokens(int currentTime) {
        int ans = 0;
        for(int val: mapp.values()){
            if(val > currentTime) ans++;
        }

        return ans;
    }
}

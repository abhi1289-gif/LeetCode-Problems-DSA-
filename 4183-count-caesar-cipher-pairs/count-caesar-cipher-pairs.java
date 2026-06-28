class Solution {

    public boolean same(String a, String b){
        int diff = (b.charAt(0) - a.charAt(0) + 26) % 26;
        for(int i=0; i<a.length(); i++){
            if(diff != (b.charAt(i) - a.charAt(i) + 26) % 26) return false;
        }

        return true;
    }

    public long countPairs(String[] words) {
        int n = words.length;
        long ans = 0;

        boolean visited[] = new boolean[n];
        
        for(int i=0; i<n-1; i++){
            int temp = 1;
            if(visited[i]) continue;
            for(int j=i+1; j<n; j++){
                if(visited[j]) continue;

                String a = words[i];
                String b = words[j];
                if(same(a, b)){
                    temp++;
                    visited[i] = true;
                    visited[j] = true;
                }
            }
            ans += (long)temp*(temp-1)/2;
        }

        return ans;
    }
}
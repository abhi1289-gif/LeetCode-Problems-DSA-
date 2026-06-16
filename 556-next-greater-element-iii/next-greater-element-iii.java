class Solution {

    public int find(HashMap<Integer, Integer> mapp, int curr){
        for(int i=curr+1; i<10; i++){
            if(mapp.containsKey(i)) return i;
        }
        return -1;
    }

    public int nextGreaterElement(int n) {
        HashMap<Integer, Integer> present = new HashMap<>();
        List<Integer> rem = new ArrayList<>();

        while(n > 0){
            int curr = n%10;
            n = n/10;

            int there = find(present, curr);
            if(there == -1){
                rem.add(curr);
                present.put(curr, present.getOrDefault(curr, 0)+1);
            }
            else{
                long ans = n;
                ans = ans*10 + there;
                present.put(there, present.get(there) - 1);
                rem.add(curr); 
                Collections.sort(rem);
                boolean taken = true;

                for(int i=0; i<rem.size(); i++){
                    if(rem.get(i)==there){
                        if(taken){
                            taken = false;
                            continue;
                        }
                        else{
                            ans = ans*10 + rem.get(i);
                        }
                    }
                    else ans = ans*10 + rem.get(i);
                }
                if(ans > Integer.MAX_VALUE) return -1;

                return (int)(ans);
            }
        }

        return -1;
    }
}
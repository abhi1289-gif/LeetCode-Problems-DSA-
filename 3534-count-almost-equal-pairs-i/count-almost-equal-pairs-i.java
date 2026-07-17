class Solution {

    public boolean areSame(int a, int b){
        if(a > b) return areSame(b, a);

        String aa = String.valueOf(a);
        String bb = String.valueOf(b);

        if(aa.length() != bb.length()){
            StringBuilder s = new StringBuilder(aa);
            while(s.length() != bb.length()) s.insert(0, '0'); 
            aa = s.toString();
        }

        if(aa.equals(bb)) return true;
        int p = -1;
        int q = -1;

        int i = 0;
        int count = 0;
        while(i < aa.length()){
            if(aa.charAt(i) != bb.charAt(i)){
                if(count == 2) return false;

                if(count == 0){
                    p = i;
                    count++;
                }
                else{
                    count++;
                    q = i;
                }

            }
            i++;
        }

        if(count == 0) return true;

        if(count == 1) return false;

        if(p == -1 || q == -1) return false;

        return aa.charAt(p) == bb.charAt(q) && aa.charAt(q) == bb.charAt(p);
    }

    public int countPairs(int[] nums) {
        int ans = 0;

        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                if(areSame(nums[i], nums[j])) ans++;
            }
        }

        return ans;
    }
}
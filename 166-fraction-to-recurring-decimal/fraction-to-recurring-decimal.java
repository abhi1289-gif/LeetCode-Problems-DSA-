class Solution {
    public String fractionToDecimal(int nn, int dd) {
        HashMap<Long, Integer> mapp = new HashMap<>();
        if(nn == 0) return "0";

        StringBuilder ans = new StringBuilder();
        StringBuilder front = new StringBuilder();

        boolean one = false;
        boolean two = false;

        long n = (long)(nn);
        long d = (long)(dd);

        if(n < 0){
            n = n*(-1);
            one = true;
        }
        if(d < 0){
            d = d*(-1);
            two = true;
        }

        if(n/d > 0){
            front.append(n/d);
            n = n%d;
        }
        else{
            front.append(0);
        }
        if(n>0) front.append('.');

        n = n*10;

        while(n > 0){
            if(mapp.containsKey(n)){
                int pos = mapp.get(n);
                ans.insert(pos, '(');
                ans.append(')');
                break;
            }
            mapp.put(n, ans.length());

            long a = n / d;
            ans.append(a);

            n = (n % d) * 10;
        }
        front.append(ans);
        if(one && two) return front.toString();
        else if(one || two){
            front.insert(0, '-');
            return front.toString();
        }
        return front.toString();
    }
}
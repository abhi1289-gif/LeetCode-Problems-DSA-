class Solution {

    public int gcd(int a, int b){
    if(b == 0) return a;
    return gcd(b, a % b);
}

    public String fractionAddition(String expression) {
        String nums[] = expression.split("(?=[+-])");
        int n = 0;
        int d = 1;

        for(String num: nums){
            boolean neg = false;
            int i = 0;
            if(num.charAt(0) == '-'){
                neg = true;
                i++;
            }
            int numerator = 0;
            int j = i;
            while(num.charAt(i)  != '/'){
                i++;
            }
            String numer = num.substring(j, i);
            numerator = Integer.valueOf(numer);

            String denom = num.substring(i+1, num.length());
            int den = Integer.valueOf(denom);

            if(neg) numerator = numerator*(-1);

            int temp1 = n*den;
            int temp2 = d*numerator;

            n = temp1 + temp2;

            d = d*den;

            int g = gcd(Math.abs(n), d);

            n /= g;
            d /= g;
        }

        String ans = n + "/" + d;

        return ans;
    }
}
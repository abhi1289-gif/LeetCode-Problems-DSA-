class Solution {
    public long sumAndMultiply(int n) {
        long dig = 0;
        int sum = 0;

        while(n > 0){
            int d = n%10;
            n = n/10;

            if(d == 0) continue;

            dig = dig*10 + (long)d;
            sum += d;
        }

        long num = 0;

        while(dig > 0){
            num = num*10 + dig%10;
            dig = dig/10;
        }

        return (long)sum * num;
    }
}
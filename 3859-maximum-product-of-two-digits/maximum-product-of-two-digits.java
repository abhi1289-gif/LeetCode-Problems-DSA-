class Solution {
    public int maxProduct(int n) {
        int a = -1;
        int b = -1;

        while(n > 0){
            int num = n % 10;
            n = n/10;

            if(num > a){
                b = a;
                a = num;
            }
            else{
                b = Math.max(num, b);
            }
            
        }

        return a*b;
    }
}
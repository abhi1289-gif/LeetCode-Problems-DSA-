class Solution {

    public boolean isEqual(int n, int t){
        int pro = 1;
        while(n > 0){
            int a  = n%10;
            n = n/10;
            pro *= a;
        }
        return pro%t == 0;
    }
    
    public int smallestNumber(int n, int t) {
        while(true){
            if(isEqual(n, t)) return n;
            n++;
        }
    }
}
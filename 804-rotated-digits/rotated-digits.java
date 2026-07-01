class Solution {

    int ans;

    public void travel(int num, int n, int spe){
        if(num > n) return;
        if(num != 0 && spe > 0) ans++;

        for(int i=0; i<10; i++){
            if(num == 0 && i == 0) continue;
            if(i == 3 || i == 4 || i == 7) continue;
            num = num*10+i;
            boolean used = false;
            if(i == 2 || i == 5 || i == 6 || i == 9){
                used = true;
                spe++;
            }
            travel(num, n, spe);
            if(used) spe--;
            num = num/10;
        }
    }

    public int rotatedDigits(int n) {
        ans = 0;
        travel(0, n, 0);
        return ans;
    }
}
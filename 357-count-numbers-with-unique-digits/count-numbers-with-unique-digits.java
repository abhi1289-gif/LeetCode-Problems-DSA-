class Solution {

    int ans;

    public void travel(int num, int len, boolean visited[], int n){
        if(len > 0) ans++;
        if(len == n) return;

        for(int i=0; i<10; i++){
            if(visited[i]) continue;
            if (len == 0 && i == 0) continue;

            visited[i] = true;
            travel(num * 10 + i, len + 1, visited, n);
            visited[i] = false;
        }
    }

    public int countNumbersWithUniqueDigits(int n) {
        // boolean visited[] = new boolean[10];
        // ans = 1;
        // if(n == 0) return 1;
        // travel(0, 0, visited, n);
        // return ans;

        if(n == 0) return 1;
        int ans = 1;
        int curr = 9;
        int avail = 9;

        for(int i=1; i<=n; i++){
            ans += curr;
            curr = curr*avail;
            avail--;
        }
        return ans;
    }
}
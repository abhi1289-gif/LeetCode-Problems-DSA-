class Solution {


    public int findLeft(int l, int r, int[] bar, int a) {
    int ans = -1;

    while (l <= r) {
        int mid = l + (r - l) / 2;

        if (bar[mid] > a) {
            ans = bar[mid];
            r = mid - 1;
        } else {
            l = mid + 1;
        }
    }

    return ans;
}

    public int[] platesBetweenCandles(String s, int[][] queries) {
        int n = s.length();

        int ans[] = new int[queries.length];
        int pre[] = new int[n];
        int bar[] = new int[n];
        int plate = 0;
        int candle = -1;

        for(int i=0; i<n; i++){
            if(s.charAt(i) == '*') plate++;
            else candle = i;
             
            pre[i] = plate;
            bar[i] = candle;
        }

        for(int i=0; i<queries.length; i++){
            int l = queries[i][0];
            int r = queries[i][1];
            if(bar[r] == -1){
                ans[i] = 0;
                continue;
            }
            
            int rightBar = bar[r];
            int leftBar = bar[l];

            if(l == bar[l]){
                ans[i] = pre[rightBar]-pre[leftBar];
            }

            if( rightBar == leftBar){
                ans[i] = 0;
                continue;
            }

            leftBar = findLeft(l, r, bar, l - 1);

            if(leftBar == -1 || rightBar == -1 || leftBar >= rightBar) ans[i] = 0;
            else ans[i] = pre[rightBar] - pre[leftBar];
        }

        return ans;
    }
}
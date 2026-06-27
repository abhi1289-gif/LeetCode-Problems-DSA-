class Solution {
    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        long ans = 0;

        int n = bottomLeft.length;

        for(int i=0; i<n-1; i++){
            for(int j=i+1; j<n; j++){
                int lx1 = bottomLeft[i][0];
                int ly1 = bottomLeft[i][1];

                int lx2 = bottomLeft[j][0];
                int ly2 = bottomLeft[j][1];

                int rx1 = topRight[i][0];
                int ry1 = topRight[i][1];

                int rx2 = topRight[j][0];
                int ry2 = topRight[j][1];

                int lx = Math.max(lx1, lx2); 
                int ly = Math.max(ly1, ly2);
                int rx = Math.min(rx1, rx2);
                int ry = Math.min(ry1, ry2);

                long a = (long) Math.min(rx-lx, ry-ly);
                if(a <= 0) continue;
                ans = Math.max(ans, 1L*a*a);
            }
        }

        return ans;
    }
}
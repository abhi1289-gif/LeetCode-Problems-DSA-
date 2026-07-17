class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        List<Integer> ans = new ArrayList<>();
        int n = mat.length;
        int m = mat[0].length;

        for(int i=0; i<n; i++){
            List<Integer> temp = new ArrayList<>();
            int a = i;
            int b = 0;

            while(a>=0 && b<m){
                temp.add(mat[a][b]);
                a--;
                b++;
            }

            if(i%2 != 0) Collections.reverse(temp);

            ans.addAll(temp);
        }

        for(int i=1; i<m; i++){
            List<Integer> temp = new ArrayList<>();
            int a = n-1;
            int b = i;

            while(a>=0 && b<m){
                temp.add(mat[a][b]);
                a--;
                b++;
            }

            if((n-1+i)%2 != 0) Collections.reverse(temp);

            ans.addAll(temp);
        }

        int[] res = new int[ans.size()];
        for (int p = 0; p < ans.size(); p++) {
            res[p] = ans.get(p);
        }

        return res;
    }
}
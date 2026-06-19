class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int len = arr.length;

        HashMap<Integer, Integer> mapp = new HashMap<>();
        int a = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                mapp.put(mat[i][j], a);
                a++;
            }
        }

        HashMap<Integer, Integer> rows = new HashMap<>();
        HashMap<Integer, Integer> cols = new HashMap<>();

        for(int i=0; i<len; i++){
            int num = arr[i];
            int place = mapp.get(num);
            int r = place/m;
            int c = place%m;

            rows.put(r, rows.getOrDefault(r, 0)+1);
            cols.put(c, cols.getOrDefault(c, 0)+1);

            if(rows.get(r) == m || cols.get(c) == n) return i;
        }

        return -1;
    }
}
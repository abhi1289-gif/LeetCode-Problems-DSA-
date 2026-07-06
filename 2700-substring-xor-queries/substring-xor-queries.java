class Solution {

    public class Pair{
        int x;
        int y;

        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public int[][] substringXorQueries(String s, int[][] queries) {
        HashMap<Integer, Pair> mapp = new HashMap<>();

        int n = s.length();

        for(int i = n - 1; i >= 0; i--) {
            int num = 0;
            int two = 1;

            for(int j = i; j >= 0 && i - j < 31; j--) {

                if(s.charAt(j) == '1') {
                    num += two;
                }

                Pair old = mapp.get(num);

                if(old == null ||
                   i - j < old.y - old.x ||
                   (i - j == old.y - old.x && j < old.x)) {

                    mapp.put(num, new Pair(j, i));
                }

                two *= 2;
            }
        }

        int ans[][] = new int[queries.length][2];
        int i = 0;

        for(int qu[]: queries){
            int c = qu[0]^qu[1];
            if(mapp.containsKey(c)){
                Pair curr = mapp.get(c);
                ans[i][0] = curr.x;
                ans[i][1] = curr.y;
            }
            else{
                ans[i][0] = -1;
                ans[i][1] = -1;
            }
            i++;
        }

        return ans;
    }
}
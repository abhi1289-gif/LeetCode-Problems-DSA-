class Solution {
    public int[][] intervalIntersection(int[][] fir, int[][] sec) {
        int i = 0;
        int j = 0;

        if(fir.length == 0 || sec.length == 0) return new int[][]{};

        List<int[]> ans = new ArrayList<>();

        while(i < fir.length && j < sec.length){
            if(fir[i][1] < sec[j][0]) i++;
            else if(fir[i][0] > sec[j][1]) j++;
            else if(fir[i][1] == sec[j][0]){
                ans.add(new int[]{fir[i][1], sec[j][0]});
                i++;
            }
            else if(sec[j][1] == fir[i][0]){
                ans.add(new int[]{fir[i][0], sec[j][1]});
                j++;
            }
            else{
                if(fir[i][1] < sec[j][1]){
                    ans.add(new int[]{Math.max(fir[i][0], sec[j][0]), fir[i][1]});
                    i++;
                }
                else{
                    ans.add(new int[]{Math.max(sec[j][0], fir[i][0]), sec[j][1]});
                    j++;
                }
            }
        }

        return ans.toArray(new int[ans.size()][]);
    }
}
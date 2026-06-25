class Solution {
    public char[][] rotateTheBox(char[][] nums) {
        int n = nums.length;
        int m = nums[0].length;

        for(int i=0; i<n; i++){
            int j = m-1;
            int idx = m-1;
            while(j>=0){
                if(nums[i][j] == '*') idx = j-1;
                else if(nums[i][j] == '#'){
                    char temp = nums[i][idx];
                    nums[i][idx] = '#';

                    if (idx != j)
                        nums[i][j] = '.';

                    idx--;
                }
                j--;
            }
        }
        char ans[][] = new char[m][n];

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                ans[j][n - 1 - i] = nums[i][j];
            }
        
        }
        return ans;
    }
}
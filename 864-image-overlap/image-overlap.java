class Solution {

    public int findSim1(int x, int y, int n, int nums[][], int arr[][]){
        int res = 0;
        for(int i=0; i<n-x; i++){
            for(int j=0; j<n-y; j++){
                if(nums[i][j] == 1 && arr[i+x][j+y] == 1) res++;
            }
        }

        return res;
    }

    public int findSim2(int x, int y, int n, int nums[][], int arr[][]){
        int res = 0;
        for(int i=n-1; i>=x; i--){
            for(int j=n-1; j>=y; j--){
                if(nums[i][j] == 1 && arr[i-x][j-y] == 1) res++;
            }
        }

        return res;
    }

    public int findSim3(int x, int y, int n, int nums[][], int arr[][]){
        int res = 0;

        for(int i = 0; i < n-x; i++){
            for(int j = y; j < n; j++){
                if(nums[i][j] == 1 && arr[i+x][j-y] == 1) res++;
            }
        }

        return res;
    }

    public int findSim4(int x, int y, int n, int nums[][], int arr[][]){
        int res = 0;

        for(int i = x; i < n; i++){
            for(int j = 0; j < n-y; j++){
                if(nums[i][j] == 1 && arr[i-x][j+y] == 1) res++;
            }
        }

        return res;
    }

    public int largestOverlap(int[][] img1, int[][] img2) {
        
        int ans = 0;
        int n = img1.length;

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                int temp = findSim1(i, j, n, img1, img2);
                ans = Math.max(ans, temp);
            }
        }

        for(int i=n-1; i>=0; i--){
            for(int j=n-1; j>=0; j--){
                int temp = findSim2(i, j, n, img1, img2);
                ans = Math.max(ans, temp);
            }
        }

        for(int i=0; i<n; i++){
            for(int j=n-1; j>=0; j--){
                int temp = findSim3(i, j, n, img1, img2);
                ans = Math.max(ans, temp);
            }
        }

        for(int i=n-1; i>=0; i--){
            for(int j=0; j<n; j++){
                int temp = findSim4(i, j, n, img1, img2);
                ans = Math.max(ans, temp);
            }
        }

        return ans;
    }
}
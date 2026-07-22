class Solution {

    public int maxOnes(int nums[], int k){
        int ans = 0;
        int j = 0;

        for(int i=0; i<nums.length; i++){
            if(nums[i] == 0) k--;

            if(k < 0){
                while(nums[j] != 0) j++;
                j++;
                k++;
            }

            ans = Math.max(ans, i-j+1);
        }

        return ans;
    }

    public int maxConsecutiveAnswers(String s, int k) {
        int n = s.length();
        int arr[] = new int[n];
        int nums[] = new int[n];

        for(int i=0; i<n; i++){
            if(s.charAt(i) == 'T'){
                nums[i] = 0;
                arr[i] = 1;
            }
            else{
                nums[i] = 1;
                arr[i] = 0;
            }
        }

        int ans = Math.max(maxOnes(arr, k), maxOnes(nums, k));

        return ans;
    }
}
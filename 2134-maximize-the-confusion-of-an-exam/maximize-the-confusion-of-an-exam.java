class Solution {

public int maxOnes(int nums[], int k){
    int maxx = 0;
    int j = 0;
    int ans = 0;

    for(int i=0; i<nums.length; i++){
        if(nums[i] == 0) k--;
        while(k < 0){
            if(nums[j] == 0) k++;
            j++;
        }

        ans = Math.max(ans, i-j+1);
    }
    return ans;
}

    public int maxConsecutiveAnswers(String s, int k) {
        int nums[] = new int[s.length()];
        int arr[] = new int[s.length()];

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == 'T'){
                nums[i] = 1;
                arr[i] = 0;
            }
            else{
                nums[i] = 0;
                arr[i] = 1;
            }
        }

        return Math.max(maxOnes(arr, k), maxOnes(nums, k));
    }
}
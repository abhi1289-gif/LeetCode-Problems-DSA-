class Solution {

    int ans;

    public void travel(List<String> arr, int nums[], int idx, int siz){
        if(idx >= arr.size()){
            ans = Math.max(siz, ans);
            return;
        }

        // nontake
        travel(arr, nums, idx+1, siz);

        // take if possible
        int temp[] = nums.clone();
        boolean take = true;

        for(char ch: arr.get(idx).toCharArray()){
            if(temp[(int)(ch-'a')] > 0){
                take = false;
                break;
            }
            temp[(int)(ch-'a')]++;
        }

        if(take) travel(arr, temp, idx+1, siz+arr.get(idx).length());
    }

    public int maxLength(List<String> arr) {
        ans = 0;
        int nums[] = new int[26];
        travel(arr, nums, 0, 0);
        return ans;
    }
}
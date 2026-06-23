class Solution {

    List<String> ans;

    public void travel(Character nums[][], int arr[], StringBuilder temp, int idx){
        if(idx == arr.length){
            ans.add(temp.toString());
            return;
        }

        for(char ch: nums[arr[idx]]){
            temp.append(ch);
            travel(nums, arr, temp, idx+1);
            temp.deleteCharAt(temp.length()-1);
        }
    }

    public List<String> letterCombinations(String digits) {
        Character nums[][] = {{'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}, {'j', 'k', 'l'}, {'m', 'n', 'o'}, {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};

        int arr[] = new int[digits.length()];

        for(int i=0; i<digits.length(); i++){
            char ch = digits.charAt(i);
            arr[i] = (int)(ch - '0')-2;
        }

        ans = new ArrayList<>();
        StringBuilder temp = new StringBuilder();
        travel(nums, arr, temp, 0);
        return ans;
    }
}
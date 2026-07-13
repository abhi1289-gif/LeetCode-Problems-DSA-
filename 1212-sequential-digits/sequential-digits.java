class Solution {

    List<Integer> ans;

    public void travel(int temp, int idx, int low, int high){
        if(temp > high) return;

        if(temp >= low && temp <= high) ans.add(temp);

        for(int i=idx; i<=9; i++){
            if(temp%10 == 0){
                temp = temp*10 + i;
                travel(temp, i+1, low, high);
                temp = temp/10;
            }
            else{
                int a = temp%10;
                if(a+1 != i) continue;
                else{
                    temp = temp*10 + i;
                    travel(temp, i+1, low, high);
                    temp = temp/10;
                }
            }                
        }
    }
    
    public List<Integer> sequentialDigits(int low, int high) {
        ans = new ArrayList<>();
        travel(0, 1, low, high);
        Collections.sort(ans);
        return ans;
    }
}
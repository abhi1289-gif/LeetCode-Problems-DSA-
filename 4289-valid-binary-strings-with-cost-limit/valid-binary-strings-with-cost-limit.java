class Solution {

    List<String> ans;

    public void make(String temp, int idx, int k, char prev, int val, int n){
        if(val > k) return;

        if (temp.length() == n) {
            ans.add(temp);
            return;
        }

        make(temp+'0', idx+1, k, '0', val, n);
        if(prev != '1'){
            make(temp+'1', idx+1, k, '1', val+idx, n);
        }
    }

    public List<String> generateValidStrings(int n, int k) {
        ans = new ArrayList<>();
        make("0", 1, k, '0', 0, n);
        make("1", 1, k, '1', 0, n);

        return ans;
    }
}
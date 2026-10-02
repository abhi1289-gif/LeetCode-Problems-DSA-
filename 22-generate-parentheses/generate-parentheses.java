class Solution {

    List<String> ans;

    public void travel(int l, int r, int n, StringBuilder temp){
        if(r == n){
            ans.add(temp.toString());
            return;
        }

        if(l<n){
            temp.append('(');
            travel(l+1, r, n, temp);
            temp.deleteCharAt(temp.length()-1);
        }

        if(r<l){
            temp.append(')');
            travel(l, r+1, n, temp);
            temp.deleteCharAt(temp.length()-1);
        }
    }

    public List<String> generateParenthesis(int n) {
        ans = new ArrayList<>();
        StringBuilder temp = new StringBuilder();
        travel(0, 0, n, temp);
        return ans;
    }
}
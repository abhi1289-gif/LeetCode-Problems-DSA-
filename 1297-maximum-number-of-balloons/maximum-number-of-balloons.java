class Solution {
    public int maxNumberOfBalloons(String s) {
        int nums[] = new int[26];

        for(int i=0; i<s.length(); i++){
            nums[(int)(s.charAt(i)-'a')]++;
        }

        int ans = Integer.MAX_VALUE;
        ans = Math.min(nums['b'-'a'], ans);
        ans = Math.min(nums['a'-'a'], ans);
        ans = Math.min((nums['l'-'a'])/2, ans);
        ans = Math.min((nums['o'-'a'])/2, ans);
        ans = Math.min(nums['n'-'a'], ans);

        return (ans != Integer.MAX_VALUE)? ans: 0;
    }
}
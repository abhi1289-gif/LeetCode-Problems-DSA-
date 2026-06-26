class Solution {
    public List<String> fullJustify(String[] words, int maxx) {
        List<String> ans = new ArrayList<>();
        int n = words.length;

        int len[] = new int[n];

        for(int i=0; i<n; i++){
            len[i] = words[i].length();
        }

        int pre[] = new int[n];
        pre[0] = len[0];
        for(int i=1; i<n; i++){
            pre[i] = pre[i-1] + len[i];
        }

        int j = 0;

        while(j < n){
            int i = j;
            int temp = len[j];
            j++;
            while(j < n && temp + 1 + len[j] <= maxx){
                temp += 1 + len[j];
                j++;
            }
            StringBuilder t = new StringBuilder();
            int totalChars = pre[j - 1] - (i == 0 ? 0 : pre[i - 1]);
            int gaps = j - i - 1;
            int spaces = 1;
            int extra = 0;

            if (gaps > 0) {
                spaces += (maxx - totalChars - gaps) / gaps;
                extra = (maxx - totalChars - gaps) % gaps;
            }
            boolean lastLine = (j == n);
            for(int a=i; a<j; a++){
                t.append(words[a]);
                if(a != j - 1){
                    if (lastLine || gaps == 0) {
                        t.append(' ');
                    } else {
                        t.append(" ".repeat(spaces));

                        if (extra > 0) {
                            t.append(' ');
                            extra--;
                        }
                    }
                }
            }
            while (t.length() < maxx) {
                t.append(' ');
            }
            ans.add(t.toString());
        }

        return ans;
    }
}
class Solution {
public:

    vector<vector<string>> ans;

    bool isPalindrome(string s, int start, int end){
        while(start<=end){
            if(s[start] != s[end]) return false;
            start++;
            end--;
        }
        return true;
    }

    void makPart(string s, vector<string> &temp, int start){
        if(start >= s.size()){
            ans.push_back(temp);
            return;
        }
        for(int end = start; end<s.size(); end++){
            if(isPalindrome(s, start, end)){
                temp.push_back(s.substr(start, end-start+1));
                makPart(s, temp, end+1);
                temp.pop_back();
            }
        }

    }

    vector<vector<string>> partition(string s) {
        ans.clear();
        vector<string> temp;
        makPart(s, temp, 0);
        return ans;
    }
};
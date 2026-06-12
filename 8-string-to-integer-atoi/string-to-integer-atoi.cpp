class Solution {
public:
    int myAtoi(string s) {
        if(s.empty()) return 0; 
        if(!((s[0]>='0' && s[0]<='9') || s[0]=='-' || s[0]=='+' || s[0]==' ')) return 0;
        bool lt = false;
        long long sum = 0;
        int start = 0;

        while(start < s.size() && s[start] == ' ') start++;
        if(start == s.size()) return 0;

        if(s[start]=='-'){
            lt = true;
            start++;
        }
        else if(s[start]=='+'){ 
            start++; 
        }

        for(int i=start; i<s.size(); i++){
            if(s[i]>= '0' && s[i] <= '9'){
                int digit = s[i]-'0';

                if(!lt && (sum > INT_MAX/10 || (sum == INT_MAX/10 && digit > 7)))
                    return INT_MAX;

                if(lt && (sum > (long long)INT_MAX/10 || (sum == (long long)INT_MAX/10 && digit > 8)))
                    return INT_MIN;

                sum = sum*10 + digit;
            }
            else break;
        }
        return lt ? -sum : sum;
    }
};
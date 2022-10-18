class Solution {
public:
    string countAndSay(int n) {
        
        
        return recur(n);
        
    }
    
    string recur(int n){
        if(n==1)
            return "1";
        
        string prev = recur(n-1);
        
        return say(prev);
    }
    
    string say(string s){
        if(s.length()==1)
        {
            return "1"+s;
        }
        
        string c = s.substr(0, 1);
        int count=1;
        string res="";
        for(int i=1; i<s.length(); i++){
            if(s.substr(i, 1)==c)
                count++;
            else{
                res += (to_string(count)+c);
                c=s.substr(i, 1);
                count=1;
            }
        }
        res += (to_string(count)+c);
        return res;
  }
};

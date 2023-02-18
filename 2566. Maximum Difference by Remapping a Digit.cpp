class Solution {
public:
    int minMaxDifference(int num) {
        string n1= to_string(num);
        string n2=to_string(num);
        char c=n1[0],ch=n1[0];
        for (int i=0; i<n1.size();i++){
            if(n1[i]!='9'){
                c=n1[i];
                break;
            }
        }
        for (int i=0; i<n1.size();i++){
            if(n1[i]==c)n1[i]='9';
        }
         for (int i=0; i<n1.size();i++){
             if(n2[i]==ch) n2[i]='0';
         }
        int mx=stoi(n1),mn=stoi(n2);
        return mx-mn;
    }
};

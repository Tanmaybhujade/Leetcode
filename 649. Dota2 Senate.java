class Solution {
public String predictPartyVictory(String s)

{
    int k=s.length();
        for(int i=1;i<s.length();i++)
        {  char c=s.charAt(0);
               if(c!=s.charAt(i))
               {
                   
                       if(i+1<s.length())
                                s=s.substring(1,i)+s.substring(i+1);
                       else
                                s=s.substring(1,i);
                       s+=c;
                       i-=2;
               }
         // System.out.println(s);
        }
   if(s.charAt(0)=='R')
           return "Radiant";
        else
                return "Dire";
   }
}

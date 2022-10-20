class Solution {
    
    StringBuilder ans = new StringBuilder();
    
    public String intToRoman(int num) {
        
        char x[] = {'x' , 'y' , 'M' , 'D' , 'C' , 'L' , 'X' , 'V' , 'I'};
        int y[] = {1 , 10 , 100 , 1000};
        int count = 3;
        int i=0;
        while(count>=0){
            int f = y[count];
            int q = num/f;
            ans(q , x[i] , x[i+1] , x[i+2]);
            num -= f*q;
            count--;
            i+=2;
        }
        return ans.toString();
    }
    
    public void ans(int x , char l , char m , char s){
        if(x == 4){
            ans.append(s);
            ans.append(m);
        }
        else if(x == 9){
            ans.append(s);
            ans.append(l);
        }
        else{
            if(x>=5){
                x-=5;
                ans.append(m);
            }
            while(x-->0)
                ans.append(s);
        }
    }
}

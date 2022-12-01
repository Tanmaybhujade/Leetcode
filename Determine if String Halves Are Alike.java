kclass Solution {
    public boolean halvesAreAlike(String s) {
        int count = 0;
        String s1 = s.substring(0,s.length()/2);
        String s2 = s.substring(s.length()/2);
        
        for(int i = 0;i<s1.length();i++){
            if(isVowel(s1.charAt(i)))
                count++;
            if(isVowel(s2.charAt(i)))
                count--;
        }
        if(count ==0)
            return true;
        return false;
        
    }
    
    boolean isVowel(Character c){
        if(c=='a' ||c=='e' ||c=='i' ||c=='o' ||c=='u' ||c=='A' ||c=='E' ||c=='I' ||c=='O' ||c=='U')
            return true;
        return false;
    }
}

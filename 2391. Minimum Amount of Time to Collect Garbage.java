class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        int n = garbage.length, t = travel.length;
        //garbage type and time taken for each
        int glass = 0, paper= 0, metal = 0;
        for(int i = n-1; i>=0; i--) {
//i==t or garpage type(p,g,m)=0 then travel time = 0
            paper+= i==t || paper==0? 0 : travel[i]; 
            glass+= i==t || glass==0? 0 : travel[i]; 
            metal+= i==t || metal==0? 0 : travel[i]; 
            String s = garbage[i];
            for(int j = 0;j < s.length(); j++) {
                char c = s.charAt(j);
                if(c=='P') {
                    paper++;
                } else if(c=='G') {
                    glass++;
                } else {
                    metal++;
                }
            }
        }
        return glass+paper+metal;
    }
}

class Solution {
    HashSet<String> set;
    public List<String> findAllConcatenatedWordsInADict(String[] words) {

        set = new HashSet<>();

        for(String str : words){ set.add(str); }

        List<String> ans = new ArrayList<>();

        for(String str : words){
            if(req(str,0)){ ans.add(str); }
        }

        return ans;
        
    }
    public boolean req(String str, int index){

        if(index == str.length()){ return true; }

        StringBuilder s = new StringBuilder();

        for(int i=index; i<str.length(); i++){

            s.append(str.charAt(i));
            if(str.length() != s.length() && set.contains(s.toString()) && req(str,i+1)){ return true; }

        }

        return false;

    }
}

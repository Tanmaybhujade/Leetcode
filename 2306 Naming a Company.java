class Solution {
    public long distinctNames(String[] ideas) {
        HashSet<String>[] initial_group=new HashSet[26];

        for(int i=0;i<26;i++){
            initial_group[i]=new HashSet<>();
ta
        }

        for(String idea:ideas){
            initial_group[idea.charAt(0)-'a'].add(idea.substring(1));

        }

        long count=0;
        for(int i=0;i<26;i++){
            for(int j=i+1;j<26;j++){
                long mutuals=0;

                for(String str:initial_group[i]){
                    if(initial_group[j].contains(str)){
                        mutuals++;
                    }

                }

                count+=2*(initial_group[i].size()-mutuals)*(initial_group[j].size()-mutuals);

            }

        }
        return count;
    }
}

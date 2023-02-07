class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer, Integer> map= new HashMap<>();
        int max=0,i=0;
        for(int j=0; j<fruits.length; j++){
            if(!map.containsKey(fruits[j])){
                    while(map.size()==2){
                        map.put(fruits[i],map.get(fruits[i])-1);
                        if(map.get(fruits[i])==0) map.remove(fruits[i]);
                        i++;
                    }
                map.put(fruits[j],1);
            }else{
                map.put(fruits[j],map.get(fruits[j])+1);
            }
            max=Math.max(max,j-i+1);
        }
        return max;
    }
}
	

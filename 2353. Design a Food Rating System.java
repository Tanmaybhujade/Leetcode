class FoodRatings 
{
    class Pair implements Comparable<Pair>
    {
        String s;int r;
        
        Pair(String a,int b)
        {
            s=a;
            r=b;
        }
        
        public int compareTo(Pair obj)
        {
            if(this.r!=obj.r)
            return obj.r-this.r;
            
            return this.s.compareTo(obj.s);
            
        }
    }
    
    Map<String,PriorityQueue<Pair>> map;
    Map<String,Integer> name;
    Map<String,String> c;
    Pair a[];
    
    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) 
    {
        int n=foods.length;
        
        map=new HashMap<>();
        name=new HashMap<>();
        c=new HashMap<>();
        
        a=new Pair[n];
        
        for(int i=0;i<n;i++)
        {
            a[i]=new Pair(foods[i],ratings[i]);
            
            name.put(foods[i],i);
            c.put(foods[i],cuisines[i]);
            
            if(!map.containsKey(cuisines[i]))
            map.put(cuisines[i],new PriorityQueue<>());
            
            PriorityQueue<Pair> temp=map.get(cuisines[i]);
            temp.offer(a[i]);
            map.put(cuisines[i],temp);
                
        }
    }
    
    public void changeRating(String food, int newRating) 
    {
        int pos=name.get(food);
        
        map.get(c.get(food)).remove(a[pos]);
        a[pos].r=newRating;
        map.get(c.get(food)).offer(a[pos]);
    }
    
    public String highestRated(String cuisine) 
    {
        return map.get(cuisine).peek().s;
    }
}

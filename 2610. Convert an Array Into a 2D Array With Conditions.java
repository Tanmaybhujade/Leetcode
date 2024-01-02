class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
    List<List<Integer>> matrix = new ArrayList<>();
    Map<Integer,Integer> map = new HashMap<>();
    int maxFreq=0;
    for(int n: nums)
    {
        if(map.containsKey(n))
        {
             map.put(n,map.get(n)+1);
        }
        else
        {
            map.put(n,1);
        }
    }

    for(Map.Entry<Integer,Integer> entry : map.entrySet())
    {   
        if(entry.getValue()>maxFreq)
        {
            maxFreq=entry.getValue();
        }

    }
    System.out.println("the maximum frequency is:"+ maxFreq);
    for(int i=0;i<maxFreq;i++)
    {
        List<Integer> childMatrix = new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry: map.entrySet())
        {
            if(entry.getValue()>=1)
            {
                childMatrix.add(entry.getKey());
                map.put(entry.getKey(),entry.getValue()-1);
            }
        }
        matrix.add(childMatrix);
       
    }
    return matrix;
    
}
}

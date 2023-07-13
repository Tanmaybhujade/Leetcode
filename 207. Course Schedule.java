class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n=numCourses;
        List<List<Integer>> list=new ArrayList<>();
	    for(int i=0;i<n;i++)
	    {
	        list.add(new ArrayList<>());
	    }
        for(int i[]:prerequisites)
        {
            list.get(i[1]).add(i[0]);
        }
        
        int indegree[]=new int[n];
	    for(int i=0;i<n;i++)
	    {
	        for(int j:list.get(i))indegree[j]++;
	    }
	    Queue<Integer> q=new LinkedList<>();
	    for(int i=0;i<n;i++){
	        if(indegree[i]==0)q.add(i);
	    }
        List<Integer> res=new ArrayList<>();
	    while(!q.isEmpty())
	    {
	        int val=q.poll();
	        res.add(val);
	        for(int i:list.get(val)){
	            if(--indegree[i]==0)q.add(i);
	        }
	    }
        return !(res.size()!=n);
    }
}

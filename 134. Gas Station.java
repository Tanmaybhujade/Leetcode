public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if(cost.length==0) return -1;
		int remaining=-1;
		int start_i=0;
		int i=0;

		while(i<2*gas.length)
		{
			int index=i%gas.length;
			if(remaining<0)
			{
				if(gas[index]>=cost[index])
				{
					remaining=gas[index]-cost[index];
					start_i=index;
				}
			}
			else
			{
				if(start_i==index) return start_i;
				remaining+=gas[index]-cost[index];
			}
			i++;
		}
		return -1;
	}    
}

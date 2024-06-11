class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        //Store the elements of arr1 which are not present in the arr2
        List<Integer> al = new ArrayList<>();
        // Store the elements in the required sorted order
        int[] ans = new int[arr1.length];
        //Stores the frequencies of all the elements of arr1
        Map<Integer, Integer> mp = new HashMap<>();
        for(int i : arr1) mp.put(i, mp.getOrDefault(i, 0) + 1);
        //Pointer that will traverse the arr2 and store the elements in the new ans array
        int i = 0;
        //Pointer that will traverse the arr2
        int j = 0;
        //Traversing each element of the arr2 
        while(j < arr2.length){
            //Saving the element of the arr2 for ease
            int x = arr2[j];
            //Adding the elements with their frequency times into the resultant array
            for(int k = 0; k < mp.get(x); k++){
                ans[i++] = x;
            }
            //Remove that key element from the map that has been added into the new array
            mp.remove(x); 
            j++;
        }

        //Extracting the remaining elements from the map into the list
        for(int val : mp.keySet()){
           for(int k = 0; k < mp.get(val); k++){
               al.add(val);
           }
        } 

        //Sorting the remaining elements
        Collections.sort(al);

        //Adding them into the result array
        for(int k : al) ans[i++] = k;

        //Return the resultant array
        return ans;
    

    }
}

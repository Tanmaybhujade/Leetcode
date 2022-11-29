class RandomizedSet {

    Set <Integer> set;
    Random randomNumber;
    
    public RandomizedSet() {
        set = new HashSet<>();
        randomNumber = new Random();
    }
    
    public boolean insert(int val) {
        if(set.contains(val))   return false;
        set.add(val);   return true;
    }
    
    public boolean remove(int val) {
        if(!set.contains(val))  return false;
        set.remove(val);    return true;
    }
    
    public int getRandom() {
        Integer[] temp = set.toArray(new Integer[0]);
        return temp[randomNumber.nextInt(set.size())];
    }
}

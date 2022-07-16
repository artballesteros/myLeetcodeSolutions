/**
Key Idea:
    Use a hashset to keep track of previous values. We don't really
    need to store a count (like with a hashmap) we just need to 
    store a 'visit'. We iterate through the array, check if current
    value was found already in the hashset and return true if so.
    This means the value had already been visited. Otherwise, the value
    is new and we add it to our hashset. 
    
    If we reach the end of the array without ever returning true, 
    then no duplicates exist and we return false.
    
    We have O(n) runtime because we have to iterate through the
    entire array to identify duplicates and the hashset methods 
    are only O(1). We have O(n) space complexity because our 
    hashset can contain all the values in the array when no
    duplicates exist.
*/

class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num))
                return true;
            else
                set.add(num);
        }
        
        return false;
    }
}


/*
class Solution2 {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.get(num) > 1) {
                return true;
            }
        }
        
        return false;
    }
}
*/

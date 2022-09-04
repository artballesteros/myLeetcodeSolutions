/*
Key Idea:
    Solution 1: Brute Force. 
    Two loops with two "pointers" (i,j) checking if either
    nums[i] == 2 * nums[j] or nums[j] == 2 * nums[i] is true.
    
    Runtime: O(n^2)
    Space: O(1)
    
    Solution 2: HashMap
    Map 2*arr[i] to i and then iterate through array with arr[j] as
    the key. If the value exists in the hashmap, that means that 
    arr[i] * 2 == arr[j] and we return true.
    
    Runtime: O(n)
    Space: O(n)
    
    Solution 3: HashSet
    Found in the discussion section. Hashset offers O(1) access
    which allows us to quickly search for values, such as
    arr[i] and 2*arr[i] (val and twice as much).
    
    Since we are working with integers, we want to be sure
    we only divide even number by 2. Otherwise, we may get false 
    positives. 
    
    We can do this in one pass because either the partner values
    exist and will eventually be found through multiplication
    or division, or we reach the end finding they don't.
    
    The division allows us to check for previously inserted values. 
    
       arr: 1 2 3 4
    1. set: 1        contains?: 1*2 = 2 (false, continue)
    2. set: 1 2      contains?: 4,1 (return true)
    
    Runtime: O(n)
    Space: O(n)
*/

class Solution3 {
    public boolean checkIfExist(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for(int a : arr) {
            if(set.contains(a*2) || ((a % 2 == 0) && set.contains(a/2))) {
                return true;
            } 
            set.add(a);
        }
        return false;
    }
}

class Solution2 {
    public boolean checkIfExist(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>(arr.length);
        for (int i = 0; i < arr.length; ++i) {
            map.put(2*arr[i], i);
        }
        
        for (int j = 0; j < arr.length; ++j) {
            int index = map.getOrDefault(arr[j], -1);
            if (index != -1 && index != j) {
                return true;
            }
        }
        return false;
    }
}

class Solution1 {
    public boolean checkIfExist(int[] arr) {
        for (int i = 0; i < arr.length - 1; ++i) {
            for (int j = i + 1; j < arr.length; ++j) {
                if (arr[i] == 2 * arr[j] || arr[j] == 2 * arr[i]) {
                    return true;
                }
            }
        }
        return false;
    }
}

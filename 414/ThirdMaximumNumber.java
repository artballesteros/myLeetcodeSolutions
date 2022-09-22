/*
[easy]
Key Idea:
    Solution 1:
    Sort the input array and return third unique number from the right.
    
    Time: O(nlogn) (due to the sorting)
    Space: O(1)
    
    Solution 2:
    We use a Set to keep track of the three largest unique values as we 
    iterate through the input array. 
    
    If our set it ever larger than 3, we search for the smallest value in the
    set and remove it. 
    
    Time: O(n) (the array is only iterated once, O(n), and the search algorithms
    that search for the smallest and largest values in a set only ever have
    to look through 3 values, hence they are O(1)).
    
    Space: O(1) (The size of the set can at most be 3.)
    
    *This problem is best solved with sets*
    We could have also iterated through the array at most three times and
    add the three largest values if they exist. We do this finding the largest
    value in each iteration that isn't equal to some value already in the set.
    
    Time: O(n) (O(3n) but we remove constants)
    Space: O(1) (set size restricted to three values)
    
    We could have also added all the values in the array to a set to remove 
    duplicates and then remove the two largest values in the set while returning
    the third if it exists.
    
    Time: O(n) (O(3n)) 
    Space: O(n) (worst case is when array has only unique values)
    
    Of course, we should handle edge cases like small arrays/sets (<3). In such cases, 
    we return the largest values in the set.
    
    I also noted some people using TreeSet and PriorityQueue for this problem. An
    array solution exists but it's ugly. The logic would be the same actually, we
    just use three variables instead of a set to keep track of our 
    moving window values.
    
    Java has Collections.max() and .min() that I could have used instead of creating
    my own max/min search methods.
*/
class Solution2 {
    public int thirdMax(int[] nums) {
        Set<Integer> set = new HashSet<>(3);
        for (int num : nums) {
            set.add(num);
            if (set.size() > 3) {
                set.remove(smallest(set));
            }
        }
        
        if (set.size() == 3)
            return smallest(set);
        
        return largest(set);
    }
    
    public int smallest(Set<Integer> set) {
        int smallest = Integer.MAX_VALUE;
        for (int num : set) {
            if (num < smallest) {
                smallest = num;
            }
        }
        return smallest;
    }
    
    public int largest(Set<Integer> set) {
        int largest = Integer.MIN_VALUE;
        for (int num : set) {
            if (num > largest) {
                largest = num;
            }
        }
        return largest;
    }
}

class Solution1 {
    public int thirdMax(int[] nums) {
        Arrays.sort(nums);
        int curr = nums[nums.length - 1];
        int changes = 1;
        for (int i = nums.length - 1; i >= 0; --i) {
            if (curr != nums[i]) {
                changes++;
                curr = nums[i];
            }
            
            if (changes == 3) {
                return curr;
            }
        }
        
        if (changes < 3) {
            curr = nums[nums.length - 1];
        }
        
        return curr;
    }
}

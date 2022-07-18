/**
Key Idea:
    Keep track of input integers using a hashset and use it
    to also check for consecutive integers. Skip any element
    that has a preceeding integer in the hashset because 
    this would mean that the element is not the start of
    a sequence but part of a larger one. 
    
    Skipping non-starters would reduce the runtime from
    O(n^2) to O(n) because in the worst case, we would
    visit each element (other than the first) twice.
    
    Ex.
    
    po: ptr of outer for loop
    pi: ptr of inner while loop
    
    1,   2,   3,   4
    ^
    po
    pi
     
    We start by filling a hashset.
    We then start a loop on the first element and
    find that it has no preceeding values, so we
    continue with an inner loop that only runs if
    there is a consecutive value in the hashset.
    
    1,   2,   3,   4
    ^
    po
    ^    ^    ^    ^
    pi > pi > pi > pi
    
    For the array above, this runs until the 
    current value is 4 + 1 = 5, which doesn't exist
    in the hashset (nor the array).
    
    After that, we increment the outer pointer
    and reset the inner pointer.
    
    1,   2,   3,   4
         ^
         po
         ^ 
         pi 
         
    Since the remaining elements all
    have preceeding consecutive values in the 
    hashset, we don't run the inner loop. We
    just iterate through the remaining elements
    once again.
    
    Runtime: O(2n - 1) -> O(n)
    Space: O(n) (all array elements unique)
*/
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums)
            set.add(num);
        
        int length = 0;
        for (int num : nums) {
            int count = 0;
            if (!set.contains(num - 1)) {
                while (set.contains(num)) {
                    count++;
                    num++;
                    if (length < count) {
                        length++;
                    }
                }
            }
        }
        
        return length;
    }
}

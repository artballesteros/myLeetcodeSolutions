/*
Key Idea:
    Two pointer approach. Very similar to Prob. 27: Remove element.
    One pointer to keep track of valid subarray end, another pointer
    to act as a walker. Difference is, we now change the target
    val whenever we come across a new value.
    
    1. 
        1 2 2 3 3
          ^
          *
    2. 
        1 2 2 3 3
            ^
            *
    3. 
        1 2 2 3 3
              ^
            *
        1 2 3 3 3
              ^
              *
    4. 
        1 2 3 3 3
                ^
              *
        1 2 3 3 3
                  ^
              *
    return 3
    
    Runtime: O(n)
    Space: O(1)
*/

class Solution {
    public int removeDuplicates(int[] nums) {
        int available = 1;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] != nums[available - 1]) {
                nums[available] = nums[i];
                available++;
            }
        }
        return available;
    }
}

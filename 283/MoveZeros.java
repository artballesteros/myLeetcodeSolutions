/*
Key Idea: 
    Use two pointers to identify positions to swap.
    If the writer pointer is not a zero, we swap its
    value with the last position that contained a zero.
    
    ex. 
    
    ^ walker
    * writer
    swap(index,index)
    
    1.
        1 0 2 0 
        ^
        *
        swap(0,0)
    2.
        1 0 2 0 
          ^
          *
        continue
    3.
        1 0 2 0 
            ^
          *
        swap(1,2)
    4.
        1 2 0 0 
              ^
            *
    Done.
    
    Runtime: O(n)
    Space: O(1) (infix operation)
*/
class Solution {
    public void moveZeroes(int[] nums) {
        int writer = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != 0) {
                swap(nums, writer, i);
                writer++;
            }
        }
    }
    
    public void swap(int[] nums, int from, int to) {
        int temp = nums[from];
        nums[from] = nums[to];
        nums[to] = temp;
    }
}

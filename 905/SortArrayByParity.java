/*
Key Idea:
    Use two pointers technique to identify even and odd number.
    Writer pointer keeps track of end of even subarray while
    the reader pointer reads through the rest of the array and
    checks for even numbers. If an even number is found, we
    swap its value with that pointed by the writer pointer, which
    contains an odd number. We then increment the writer.
    
    Same reasoning behind Problem 283: Move Zeros
    
    Runtime: O(n)
    Space: O(1)
*/
class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int writer = 0;
        for (int reader = 0; reader < nums.length; ++reader) {
            if (nums[reader] % 2 == 0) {
                swap(nums, reader, writer);
                writer++;
            }
        }
        return nums;
    }
    
    public void swap(int[] nums, int from, int to) {
        int temp = nums[from];
        nums[from] = nums[to];
        nums[to] = temp;
    }
}

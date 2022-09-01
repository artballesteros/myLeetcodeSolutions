/*
Key Idea:
    Start at the second index and add previous index value as you
    iterate through the array.
    
    1 2 3 4 5
      ^
    start
    
    Now keep adding previous until you reach the end of the array.
*/
class Solution {
    public int[] runningSum(int[] nums) {
        for (int i = 1; i < nums.length; ++i) {
            nums[i] += nums[i - 1];
        }
        return nums;
    }
}

/*
[easy]
Key Idea:
    Just find the largest value and then compare it with the rest of the values.
    Keep note of the index.
    
    Time: O(n) (2n; we loop twice through the array, once for max, twice for compares)
    Space: O(1)
*/
class Solution {
    private static final int MIN_VALUE = -1;
    public int dominantIndex(int[] nums) {
        int largestValue = MIN_VALUE;
        int index = MIN_VALUE;
        
        for (int i = 0; i < nums.length; ++i) {
            if (largestValue < nums[i]) {
                largestValue = nums[i];
                index = i;
            }
        }
        
        for (int j = 0; j < nums.length; ++j) {
            if (largestValue != nums[j] && 2 * nums[j] > largestValue) {
                return MIN_VALUE;
            }
        }
        
        return index;
    }
}

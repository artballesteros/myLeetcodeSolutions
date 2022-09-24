/*
[easy]
Key Idea:
    Solution 1:
    Just find the largest value and then compare it with the rest of the array.
    Keep note of the index.
    
    Time: O(n) (2n; we loop twice through the array, once for max, twice for compares)
    Space: O(1)
    
    Solution 2:
    You can just find the two largest values and compare them. You can do
    this with two passes like the first solution does or you can do it with 
    once pass through the array by using two variables that "slide" accross
    the array.
    
    Time: O(n) (one pass!)
    Space: O(1)
*/

class Solution1 {
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

class Solution2 {
    public int dominantIndex(int[] nums) {
        int max = -1; int sMax = -1; int index = -1;
        for (int i = 0; i < nums.length; ++i) {
            if (max < nums[i]) {
                sMax = max;
                max = nums[i];
                index = i;
            } else if (sMax < nums[i]) {
                sMax = nums[i];
            }
        }
        return max >= 2*sMax ? index : -1;
    }
}

/*
[easy]
Key Idea:
    Solution 1:
    We could solve this a couple of ways. One way would be to 
    create a hashmap to keep count of all values between
    [1, n] and return an array holding all keys that have a
    value of zero. You could also use an array to do this.
    
    Space: O(n) (hashmap size n; output list doesn't count as extra)
    Time: O(n)
    
    Solution 2:
    We note that the size of an input array and the largest possible
    value are equal. Since the range of values within the array are
    always between 1 and n, we can pretend that the indices are the
    values already sorted and all subtracted by one (since the 
    array is zero indexed). If we do this, we loop through the 
    array and mark all found values by marking their index values.
    In this case, we set them as negative but we can do other things
    that are more expensive (new pair class or something p(value, bool)).
    
    We then loop through input array array again and return a list
    of non-marked indices. 
    
    ex. 
    [1, 1, 2, 3, 5] --> [-1, -1, -2, 3, -5]
                          1   2   3  4   5
    missing value: 4 (not marked)
    
    Time: O(n)
    Space: O(1) (operate inplace input array)
*/
class Solution1 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> missingNums = new LinkedList<>();
        int[] freqCount = new int[nums.length + 1];
        
        for (int num : nums) {
            freqCount[num]++;
        }
        
        for (int i = 1; i < freqCount.length; ++i) {
            if (freqCount[i] == 0) {
                missingNums.add(i);
            }
        }
        
        return missingNums;
    }
}

class Solution2 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> missingNums = new LinkedList<>();
        for (int i = 0; i < nums.length; ++i) {
            if (nums[Math.abs(nums[i]) - 1] > 0) {
                nums[Math.abs(nums[i]) - 1] *= -1;
            }
        }
        
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] > 0) {
                missingNums.add(i + 1);
            }
        }
        
        return missingNums;
    }
}

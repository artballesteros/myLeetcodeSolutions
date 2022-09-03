/*
Key Idea:
    Solution 1:
    Use two pointers coming from opposite ends to 
    compare smallest and largest absolute values.
    Write largest value to output arrays end.
    Repeat until you front > back.
    
    Time: O(n)
    Space: O(1) (output array doesn't count as extra space)

    Solution 2:
    Square each element and then sort array again.
    
    Time: O(nlogn)
    Space: O(1)
*/
class Solution {
    public int[] sortedSquares(int[] nums) {
        int front = 0;
        int back = nums.length - 1;
        int[] squared = new int[nums.length];
        int squareBack = nums.length - 1;
        while (front <= back) {
            if (Math.abs(nums[front]) < Math.abs(nums[back])) {
                squared[squareBack] = nums[back] * nums[back];
                back--;
            } else {
                squared[squareBack] = nums[front] * nums[front];
                front++;
            }
            squareBack--;
        }
        return squared;
    }
}

class Solution2 {
    public int[] sortedSquares(int[] nums) {
        for (int i = 0; i < nums.length; ++i) {
            nums[i] *= nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }
}

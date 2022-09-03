/*
Key idea:
    Solution 1:
    Two pointers at the start and end. Swap values and/or move pointers
    when you come across val.
    
    Not very pretty. :(
    
    Runtime: O(n) (you only have to traverse the array once)
    Space: O(1)
    
    Solution 2:
    Remove each value you don't want with a standard remove method.
    Keep track of subarray size as you remove (decrement).
    
    Runtime: O(n^2)
    Worst case is when we want to remove all the values in the array.
    In that case, the index, i, would remain in place while the
    size would be decremented until we reach i. During each iteration,
    we would call remove() which is O(n) in the worst case).
    
    Space: O(1)
    
    Solution 3: 
    I like this solution the best. Uses two pointers, one to 
    "walk" along the array and another to keep track of the 
    valid subarray size.
    
    The walker grabs non-target values and the size variable
    tells us where to place them within the valid subarray.
    
    You could imagine the front of the array as having a large
    magnet that just attracts non-target values.
    
    ex.
        ^ walker
        * size
        val = 4
    1. 
        1 2 4 4 5 4 5
        ^
        *
    2. 
        1 2 4 4 5 4 5
          ^
          *
    3. 
        1 2 4 4 5 4 5
            ^
            *
    4. 
        1 2 4 4 5 4 5
            ^
            *
    5. 
        1 2 4 4 5 4 5
              ^
            *
    6. 
        1 2 4 4 5 4 5
                ^
            *
        1 2 5 4 5 4 5
                ^
              *
    7. 
        1 2 5 4 5 4 5
                  ^
              *
    8. 
        1 2 4 4 5 4 5
                    ^
              *
        1 2 5 5 5 4 5
                    ^
                *
    
    Runtime: O(n)
    Space: O(1)
*/
    
class Solution3 {
    public int removeElement(int[] nums, int val) {
        int size = 0;
        for (int walker = 0; walker < nums.length; ++walker) {
            if (nums[walker] != val) {
                nums[size] = nums[walker];
                size++;
            }
        }
        return size;
    }
}

class Solution1 {
    public int removeElement(int[] nums, int val) {
        int start = 0;
        int end = nums.length - 1;
        
        if (end == 0 && nums[start] != val)
            return end + 1;
        
        if (end == 0)
            return end;
        
        while (start <= end) {
            if (nums[start] == val && nums[end] == val) {
                end--;
                continue;
            }
            
            if (nums[start] == val && nums[end] != val) {
                swap(nums, start, end);
                start++;
                end--;
                continue;
            }
            
            if (nums[start] != val && nums[end] != val) {
                start++;
                continue;
            }
            
            if (nums[start] != val && nums[end] == val) {
                end--;
                continue;
            }
        }
        
        return end + 1;
    }
    
    public void swap(int[] nums, int from, int to) {
        int temp = nums[from];
        nums[from] = nums[to];
        nums[to] = nums[from];
    }
}

class Solution2 {
    public int removeElement(int[] nums, int val) {
        int size = nums.length;
        for (int i = 0; i < size; ++i) {
            while (nums[i] == val && i < size) {
                remove(nums, i);
                size--;
            }
        }
        return size;
    }
    
    public void remove(int[] nums, int index) {
        for (int i = index; i < nums.length - 1; ++i) {
            nums[i] = nums[i + 1];
        }
    }
}

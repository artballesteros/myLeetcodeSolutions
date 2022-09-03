/*
Key Idea:
    Everytime you come accross a zero, shift all values from the
    right, to the right by one. 
    
    This shifting incidentally creates a new copy of the current zero.
    We can just skip this desired copy to prevent more copies of zero.
    
    [1, 0, 2, 3]
        ^ 
    zero found so we shift everything to the right.
    
    [1, 0, 0, 2]
        ^ 
    zero next to current zero, so we skip next one.
    
    [1, 0, 0, 2]
              ^
              
    Runtime: O(n^2) (due to constant shifting)
    Space: O(1)
*/
class Solution {
    public void duplicateZeros(int[] arr) {
        for (int i = 0; i < arr.length; ++i) {
            if (arr[i] == 0) {
                shiftNewZero(arr, i);
                ++i;
            }
        }
    }
    
    public void shiftNewZero(int[] arr, int index) {
        for (int i = arr.length - 1; i > index; --i) {
            arr[i] = arr[i - 1];
        }
    }
}

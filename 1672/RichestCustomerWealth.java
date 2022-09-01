/*
Key Idea:
    Iterate through each subarray and keep track of sum.
    Compare sum to curr largest sum and replace if larger.
    
    Time: O(n * m) (n accounts and m banks)
    Space: O(1)
*/
class Solution {
    public int maximumWealth(int[][] accounts) {
        int largest = 0;
        for (int[] account : accounts) {
            int currWealth = 0;
            for (int money : account) {
                currWealth += money;
            }
            if (currWealth > largest)
                largest = currWealth;
        }
        return largest;
    }
}

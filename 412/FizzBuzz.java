/*
Key Idea:
    Check if they are divisible by 15 first.
    Then check 3 and 5.
    
    Time: O(n)
    Space: O(1) (output list doesn't count)
*/
class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> answer = new LinkedList<>();
        for (int i = 1; i <= n; ++i) {
            if (i % 15 == 0)
                answer.add("FizzBuzz");
            else if (i % 5 == 0)
                answer.add("Buzz");
            else if (i % 3 == 0)
                answer.add("Fizz");
            else 
                answer.add(String.valueOf(i));
        }
        return answer;
    }
}

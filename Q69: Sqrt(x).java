/*
Runtime: 19 ms, faster than 8.34% of Java online submissions for Sqrt(x).
Memory Usage: 36.5 MB, less than 86.21% of Java online submissions for Sqrt(x).

Time: 25-30 minutes

Difficulty: 4 

It was okay, I just had to flesh out what squaring means, but once I found the linear incrementing algorithm, it was simple to implement. Also the long was something I had to account for.
*/

class Solution {
    public int mySqrt(int x) {
        if(x == 0)
            return 0;
        long ans = 1;
        // A linear approach to finding a square root, just keep on increasing by one the squared and find the least               square.
        while(ans*ans <= x){
            ans++;
        }
        
        return (int)ans-1;
    }
}

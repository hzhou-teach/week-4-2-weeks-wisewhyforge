/*
Runtime: 25 ms, faster than 63.81% of Java online submissions for Longest Palindromic Substring.
Memory Usage: 38.3 MB, less than 65.80% of Java online submissions for Longest Palindromic Substring.

Time: 1 and a half hour

Difficulty: 8

It took some time for me to figure out how the indices worked together and I was inspired by the expand around the center solution.
*/

class Solution {
    public String longestPalindrome(String s) {
        //Check corner cases
        int N = s.length(); 
        if(N < 1){
            return "";
        }else if(N == 1){
            return s;
        }else if(N == 2){
            if(s.charAt(0) == s.charAt(1)){
                return s;
            }else{
                return s.charAt(0) +"";
            }
        }
        //Start index of answer
        int start = 0;
        //End index of answer
        int end = 0;
        //Loop through every possible index to expand around
        for(int i = 0; i < N; i++){
            //Check for odd length
            int len1 = expandCenter(s, i,i);
            //Check for even length
            int len2 = expandCenter(s, i, i+1);
            //Check which length is bigger
            int len = Math.max(len1, len2);
            //If the answer length is bigger than the current length then set new start and end             indices
            if(len > end-start){
                start = i - (len-1)/2;
                end = i + (len)/2;
            }
        }
        
        return s.substring(start, end+1);
    }
    //Returns the length of the biggest possible palindrome around the center
    private int expandCenter(String s, int left, int right){
        //Left Index
        int L = left;
        //Right index
        int R = right;
        //Expand the left and right indices by decreasing the left and increasing the right
        while(L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)){
            L--;
            R++;
        }
        
        return R-L-1;
    }
}

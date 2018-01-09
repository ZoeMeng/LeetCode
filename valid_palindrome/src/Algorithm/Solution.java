package Algorithm;
/*
 * Given a string, determine if it is a palindrome,
 * considering only alphanumeric characters and ignoring cases.
 * For example, "A man, a plan, a canal:Panama" is a palindrome.
 * "race a car" is not a palindrome.
 * Node:
 * Have you consider that the string might be empty?
 * This is a good question of this problem, we define empty string as valid palindrome.
 */

public class Solution {
    public static void main(String[] args){
        String test = new String("race a car");
        String test2 = new String("A man, a plan, a canal:Panama");

        boolean result = isPalindrome(test), result2 = isPalindrome(test2);
        System.out.println(result);
        System.out.println(result2);
    }

    public static boolean isPalindrome(String s){
        if (s == null)
            return true;
        int i = 0, j = s.length() - 1;
        while(i < s.length()) {
            if (s.charAt(i) == s.charAt(j) || s.charAt(i) + ('a' - 'A') == s.charAt(j)
                    || s.charAt(j) + ('a' - 'A') == s.charAt(i)) {
                i++;
                j--;
            }
            else if (s.charAt(i)>'a' && s.charAt(i)<'Z' &&
                    s.charAt(j)>'a' && s.charAt(j)<'Z'){
                return false;
            }
            else if (s.charAt(i) < 'a' || s.charAt(i) > 'Z'){
                i++;
            }
            else if (s.charAt(i) < 'a' || s.charAt(i) > 'Z'){
                j++;
            }
        }


        if(i == s.length() - 1)
            return true;
        else
            return false;

    }
}

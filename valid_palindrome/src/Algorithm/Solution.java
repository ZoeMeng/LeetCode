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
        int i = 0, j = s.length() - 1;   //不要用ij这种意味不明得指针
        while(i < j) {//左指针小于右指针，作为循环条件
            //忽略大小写相等
            if (s.charAt(i) == s.charAt(j) || s.charAt(i) + ('a' - 'A') == s.charAt(j)
                    || s.charAt(j) + ('a' - 'A') == s.charAt(i)) {
                i++;
                j--;
            }
            else if (s.charAt(i)>'a' && s.charAt(i)<'Z' &&
                    s.charAt(j)>'a' && s.charAt(j)<'Z'){
                //不相等字母
                return false;
            }
            else if (s.charAt(i) < 'a' || s.charAt(i) > 'Z'){
                //左指针指向非字母
                i++;
            }
            else if (s.charAt(i) < 'a' || s.charAt(i) > 'Z'){
                //右指针指向非字母
                j--;
            }
        }


        if(i >= j)
            return true;
        else
            return false;

    }
}

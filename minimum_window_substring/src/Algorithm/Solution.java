package Algorithm;
/*
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

 * For example,
 * S ="ADOBECODEBANC"
 * T ="ABC"
 *
 * Minimum window is"BANC".
 *
 * Note:
 * If there is no such window in S that covers all characters in T, return the emtpy string"".
 *
 * If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
 */

public class Solution {

    public static void main(String[] args){
        String x1 = new String("ADOBECODEBANC");
        String x2 = new String("ABC");
        String result = minWindow(x1,x2);
        System.out.print(result);

    }

    /*
     * 链接：https://www.nowcoder.com/questionTerminal/c466d480d20c4c7c9d322d12ca7955ac
     * 来源：牛客网
     *
     * 1) begin开始指向0， end一直后移，直到begin - end区间包含T中所有字符记录窗口长度d
     * 2) 然后begin开始后移移除元素，直到移除的字符是T中的字符则停止，此时T中有一个字符没被包含在窗口，
     * 3) 继续后移end，直到T中的所有字符被包含在窗口，重新记录最小的窗口d。
     * 4) 如此循环知道end到S中的最后一个字符。
     * 时间复杂度为O(n)
     *
     * ？？？怎么表达“窗口包含T中所有字符”
     *
     */
    public static String minWindow(String S, String T){

        if(S == null || T == null)
            return "";

        int[] map = new int[128];
        //记录T中每个元素出现的次数
        for(int i = 0; i < T.length(); i++){
            map[T.charAt(i)]++;
        }


        int begin = 0, end = 0, d = Integer.MAX_VALUE, counter = T.length(), head = 0;
        while (end < S.length()){
            if(map[S.charAt(end++)]-- > 0){
                counter--;
            }
            while (counter == 0){
                if (end - begin < d){
                    d = end -(head = begin);
                }
                if(map[S.charAt(begin++)]++ == 0){
                    counter++;
                }
            }
        }

        return d == Integer.MAX_VALUE ? "" : S.substring(head , head + d); //返回子字符串或空


    }
}

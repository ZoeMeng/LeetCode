package algorithm;

import com.sun.org.apache.xalan.internal.lib.ExsltDatetime;

import java.text.SimpleDateFormat;

/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 *
 * Each element in the array represents your maximum jump length at that position.
 *
 * Your goal is to reach the last index in the minimum number of jumps.
 *
 * For example:
 *
 * Given array A =[2,3,1,1,4]
 *
 * The minimum number of jumps to reach the last index is2. (Jump1step from index 0 to 1, then3steps to the last index.)
 * 求到达list最后一个元素的最小跳跃次数。
 */

public class Solution {
    public static void main(String[] args){
        int[] a = {3,4,3,1,0,7,0,3,0,2,0,3};
        Solution so = new Solution();
        long t1 = System.nanoTime();
        int result = so.jump(a);
        long t2 = System.nanoTime();
        System.out.printf("The minimun number of jumps to the last index is : %d\n",result);
        System.out.println("程序运行时间： "+(t2-t1)+"ns");

        long t21 = System.nanoTime();
        int result2 = so.jump2(a);
        long t22 = System.nanoTime();
        System.out.printf("The minimun number of jumps to the last index is : %d\n",result2);
        System.out.println("程序运行时间： "+(t22-t21)+"ns");

    }

    /**
     * 思路：
     * 初始化步数=0，检查列表长度是否为0
     * 循环开始，1）检查当前元素能跳跃的最远位置，是否超出列表长度。若是，则返回当前步数+1。
     * 2）当前元素的跳跃范围内，寻找跳跃的最远的元素，并跳跃到这个元素的前一位置。步数+1
     * 3）直到当前元素位置超过列表长度，返回步数。
     * @param array 数组
     * @return 返回跳跃到最后一个元素的最小步数
     */
    public int jump(int[] array) {
        if (array.length == 0 || array.length == 1)
            return 0;
        int step = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] + i >= array.length - 1)
                return step + 1;

            if (array[i] > 1) {
                int max = 0, maxindex = 0;
                for (int j = 0; j < array[i]; j++) {
                    int nextstepindex = j + i + 1;
                    if ((array[nextstepindex] + nextstepindex) >= max) {
                        max = array[nextstepindex] + nextstepindex;
                        maxindex = nextstepindex;
                    }
                }
                i = maxindex - 1; // -1 为了for循环i++后，跳到这个元素
            }
            step += 1;

        }
        return step;
    }

    /**
     *
     * @param array
     * @return
     */
    public int jump2(int[] array){
        int[] dp = new int[array.length];//dp存放到各点的最小步数
        for (int i = 0; i < dp.length; i++) {
            int maxPosition = Math.min(i + array[i], array.length - 1); //从i点出发能走到得最远距离
            for(int j = i + 1; j <= maxPosition; j++){
                if (dp[j] == 0)
                    dp[j] = dp[j] + 1;
            }
            if(dp[array.length - 1] != 0) break;

        }
        return dp[array.length - 1];
    }
}

package algorithm;
/**
 * 链接：https://www.nowcoder.com/questionTerminal/32139c198be041feb3bb2ea8bc4dbb01
   来源：牛客网

 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 *
 * For example, given the array[−2,1,−3,4,−1,2,1,−5,4],
 * the contiguous subarray[4,−1,2,1]has the largest sum =6.
 *
 * click to show more practice.
 *
 * More practice:
 * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.


 */
public class Solution {
    public static void main(String[] args){
        Solution so = new Solution();
        int[] ary = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(so.maxSubArray1(ary));
    }

    /**
     * 如果当前sum>=0，则直接加下一个元素作为候选最大值，然后继续向后判断；
     * 如果当前sum<0，则下一元素无论正负，相加都不会比下一元素本身更大，所以令sum=下一个元素。
     */
    public int maxSubArray1(int[] array){
        if (array.length == 0)
            return 0;
        int max = array[0], sum = 0;
        for (int i = 0; i < array.length; i++){
            if(sum >= 0)
                sum += array[i];
            else
                sum = array[i];

            if(sum > max)
                max = sum;
        }
        return max;
    }

    /**
     * 遍历array，对于每一个数字，我们判断，（之前的sum + 这个数字） 和 （这个数字） 比大小，如果（这个数字）自己就比 （之前的sum + 这个数字） 大的话，那么说明不需要再继续加了，直接从这个数字，开始继续，因为它自己已经比之前的sum都大了。
     * 反过来，如果 （之前的sum + 这个数字）大于 （这个数字）就继续加下去。
     * 利用动态规划做题。
     * 只遍历数组一遍，当从头到尾部遍历数组A， 遇到一个数有两种选择 （1）加入之前subArray （2）自己另起一个subArray
     * 设状态S[i], 表示以A[i]结尾的最大连续子序列和，状态转移方程如下:
     * S[i] = max(S[i-1] + A[i],A[i])
     * 从状态转移方程上S[i]只与S[i-1]有关，与其他都无关，因此可以用一个变量来记住前一个的最大连续数组和就可以了。
     * 这样就可以节省空间了。
     * 时间复杂度：O(n)     空间复杂度：O(1)
     */
    public int maxSubArray2(int[] array){
        int sum = 0;
        int maxSum = array[0];
        //动态规划
        for(int i = 0; i < array.length; i++){
            sum = Math.max(sum + array[i], array[i]);
            maxSum = Math.max(sum, maxSum);
        }
        return maxSum;

    }

}

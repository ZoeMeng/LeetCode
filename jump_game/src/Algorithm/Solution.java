package Algorithm;
/*
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Determine if you are able to reach the last index.
 * For example:
 * A = [2,3,1,1,4], return true.
 * A = [3,2,1,0,4], return false.
 *
 *
 */

public class Solution {

    public static void main(String[] args){
        int[] test = {3,2,1,0,4};

    }
/*
 *
 *
 */
    public static boolean canJump(int[] A){
        int maxReach = 0;
        int n = A.length;
        for (int i = 0; i < n && i <= maxReach;i++){
            if(maxReach < (i+A[i]))
                maxReach = i + A[i];
        }

        if(maxReach < n-1)
            return false;
        return true;

    }
}

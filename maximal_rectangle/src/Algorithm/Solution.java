package Algorithm;
import java.util.Arrays;
import java.util.Stack;

import static sun.misc.Version.print;

/*
 * Given a 2D binary matrix filled with 0's and 1's. find the largest rectangle containing all ones and return its area.
 */
public class Solution {

    public static void main(String[] args){
        char[][] test = {
                {'1','0','1','0','1','1'},
                {'0','0','1','1','1','1'},
                {'1','1','1','1','1','0'}
        };

        /*
        char[][] t1 = {};
        System.out.println(t1);
        System.out.println(t1.length);
        //System.out.println(t1[0].length);

        char[][] t2 = {
                {},
                {},
                {}
        };
        System.out.println(t2);
        System.out.println(t2.length);
        System.out.println(t2[0].length);
        */


        System.out.printf("The area of largest rectangle containing all ones :%d%n", maximalRectangle(test));
    }


    private static int maximalRectangle(char[][] matrix){
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;
        int m = matrix.length, n = matrix[0].length;
        int max = 0;
        int[] h = new int[n];
        for (char[] aMatrix : matrix) {
            Stack<Integer> stack = new Stack<Integer>();
            stack.push(-1);// push压入
            for (int j = 0; j < n; j++) {
                if (aMatrix[j] == '1')
                    h[j] += 1;
                else
                    h[j] = 0;

            }
            for (int j = 0; j < n; j++) {
                //把堆栈中比h[i]大的元素都pop出，并计算面积；若没有比h[i]更大的，则将i压入栈
                while (stack.peek() != -1 && h[j] < h[stack.peek()]) {
                    int top = stack.pop();
                    max = Math.max(max, (j - 1 - stack.peek()) * h[top]);
                }
                stack.push(j);

            }
            while (stack.peek() != -1) {
                int top = stack.pop();
                max = Math.max(max, (n - 1 - stack.peek()) * h[top]);
            }

        }
        return max;

    }
}

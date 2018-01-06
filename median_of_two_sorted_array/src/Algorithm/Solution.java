package Algorithm;

/*
 * There are two sorted arrays A and B of size m and n respectively.
 * Find the median of the two sorted arrays.
 * the overall run time complexity should be O(log(m + n)).
 */

public class Solution {

    public static void main(String[] args){
        int[] x1 = {};
        int[] x2 = {1,2};

        double result = findMedianSortedArrays(x1,x2);
        System.out.println(result);

    }

    /*
     * 1.如果A或B为空，判断非空数组长度奇偶性，直接求中位数
     * 2.如果A，B都非空，m+n为奇数，并归到(m+n)/2 + 1，取出(m+n)/2 + 1
     * 3.如果为偶数，并归到(m+n)/2 + 1，取(m+n)/2+1和(m+n)/2的均值
     *
     */
    public static double findMedianSortedArrays(int A[], int B[]){
        int alen = A.length;
        int blen = B.length;
        int mid = (alen + blen)/2;


        if(alen == 0 || A == null)
            return ((alen+blen) % 2 == 0)?(B[mid] + B[mid - 1])/2.0 : B[mid ];
        if(blen == 0 || B == null)
            return ((alen+blen) % 2 == 0)?(A[mid] + A[mid - 1])/2.0 : A[mid ];

        int k = 0,i = 0, j = 0;
        int[] test = new int[alen+blen];
        while(k < mid + 1){
            if(i<alen && j<blen) {
                if (A[i] <= B[j])
                    test[k++] = A[i++];
                else
                    test[k++] = B[j++];
            }
            else if(i >= alen){
                test[k++] = B[j++];
            }
            else{
                test[k++] = A[i++];
            }
        }
        return ((alen+blen) % 2 == 0)?(test[k - 2] + test[k-1])/2.0 : test[k - 1];





    }







}

package algorithm;


//import algorithm.Point;

import java.util.HashMap;
import java.util.Map;




/**
 * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 */

public class Solution {
    public static void main(String[] args){
        Solution solu = new Solution();
        Point[] test = new Point[10];
        for (int i = 0; i < test.length; i++) {
            int x = (int)(Math.random() * 5);
            int y = (int)(Math.random() * 5);
            test[i] = new Point(x,y);
        }
        Point[] test2 = new Point[3];
        test2[0] = new Point(2,3);
        test2[1] = new Point(3,3);
        test2[2] = new Point(-5,3);
        int result2 = solu.maxPoints(test2);
        int result = solu.maxPoints(test);
        System.out.printf("The maximum number of points that lie on the same straight line is : %d\n",result2);
        float f = (float)0/-9;
        System.out.printf("The float number is: %f\n",f);
        String f_S = String.format("%.4f",f);
        System.out.printf("The String value of the float number %f is: %s \n",f,f_S);

    }

    /**
     * 要点：
     * 0. 判断点集是否存在和下于两个点的特殊情况。
     * 1. 判断两个点是否在同一条直线上，转化为：判断斜率，例点直线AB的斜率=直线AC的斜率，则A、B、C在同直线上。
     * 2. 求直线斜率，转化为：(y1-y2)/(x1-x2)
     * 3. 要考虑存在相同坐标的两个点的情况
     * 4. 要考虑斜率不存在的情况，即x1-x2 = 0
     * 5. 用HashMap（键：斜率；值：等于该斜率的直线的个数），这样统计A点和其余所有点组成的直线的斜率
     * 6. 判断斜率是否相等，不应该比较float,应该转化成字符串比较前n位
     * 7. 字符串的比较问题，是用“==”还是用".equal()"。String类型不是基本型，是一个对象类型，它在堆上开辟一个存储区域
     * ，并在栈上创建一个变量名保存这个变量在堆上的地址。如果用"=="比较的是栈中的值，即对象地址，用equal()方法比较的是值，用的是HashCode
     *
     *
     * @param points 点集
     * @return 同一条直线上的最大点数
     */
    public int maxPoints(Point[] points){
        int n = points.length;
        if (n < 2 || points == null)
            return n;

        int ret = 0;
        for (int i = 0; i < n; i++){
            //分别统计与点i重合以及垂直的点得个数
            int dup = 1, vtl = 0;
            Map<String, Integer> map = new HashMap<String, Integer>();
            Point a = points[i];

            for (int j = i+1; j < n; j++){
                //if(i == j) continue;
                Point b = points[j];
                if(a.x == b.x){
                    if(a.y == b.y) dup++;  //如果x,y都相等，与a重复点加一
                    else vtl++;//如果y不相等，x相等，与a垂直的（即斜率k不存在）加一
                }
                else if (a.y == b.y){ //记录斜率为0的情况，因为当出现x坐标正负号时，会出现+0.00和-0.00

                    if(map.get(String.valueOf(0.0000)) == null)
                        map.put(String.valueOf(0.0000),1);
                    else
                        map.put(String.valueOf(0.0000),(1 + map.get(String.valueOf(0.0000))));
                }
                else {
                    //将斜率和该斜率的出现次数存入键值对map
                    float slop = (float)(a.y-b.y) / (a.x-b.x);
                    String slop_ = String.format("%.4f",slop);
                    if(map.get(slop_) == null)
                        map.put(slop_,1);
                    else
                        map.put(slop_,(1 + map.get(slop_)));
                }
            }
            int max = vtl;
            for(String k: map.keySet()){ //获取map中key集合
                max = Math.max(max, map.get(k));
            }
            ret = Math.max(ret, max + dup);//加上和A同坐标的点，求出a的同直线上最大点的个数
        }
        return ret;
    }
}

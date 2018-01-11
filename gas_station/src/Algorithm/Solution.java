package Algorithm;
/*
 * There are N gas station along a circular route, where the amount of gas at station i is gas[i].
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station(i+1).
 * You begin the journey with an empty tank at one of the gas stations.
 * Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.
 * Note: the solution is guaranteed to be unique.
 */
public class Solution {
    public static void main(String[] args){
        int[] gas = {2,4};
        int[] cost = {3,4};
        int result = canCompleteCircuit(gas, cost);
        System.out.println(result);
    }

    /*
     * 解有且只有一个，所以只有从起点start出发
     * 才可以走完全程；这也就是说，从另一个起点出发，无法走到start；
     * 所以当出现本次剩余汽油量为<0时，该位置如果是起点返回index，否则返回-1
     */
    public static int canCompleteCircuit(int[] gas, int[] cost){
        if(gas == null || cost == null)
            return -1;

        int index = -1, remain = 0, total = 0;
        for (int i = 0; i < gas.length; i++){
            total += gas[i] - cost[i];
            remain += gas[i] - cost[i];
            //如果本次剩余<0，说明不能由i走到i+1
            if(remain < 0){
                remain = 0;
                index = i;
            }
        }
        return total >= 0 ? index + 1 : -1;

    }

}

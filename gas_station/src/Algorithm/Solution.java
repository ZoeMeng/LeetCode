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

    public static int canCompleteCircuit(int[] gas, int[] cost){
        if(gas == null)
            return -1;
        if(gas.length == 1 && gas[0] >= cost[0])
            return 0;

        int carGas;//记录车上的油还有多少
        int startstation ;//指针指向起点
        int endstation;

        for(startstation = 0; startstation < gas.length; startstation++){
            endstation = startstation + 1;
            carGas = gas[startstation];

            while(carGas- cost[(endstation - 1) % gas.length] >= 0){
                carGas = carGas - cost[(endstation - 1) % gas.length];
                endstation = endstation + 1;
            }
            if(endstation == startstation) {
                return startstation;
            }

        }
        return -1;
    }

}

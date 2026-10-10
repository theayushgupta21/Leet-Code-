class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalSurplus = 0; // net gas over the whole circuit
        int tank = 0;         // net gas since the current candidate start
        int start = 0;

        for (int i = 0; i < gas.length; i++) {
            int diff = gas[i] - cost[i];
            totalSurplus += diff;
            tank += diff;

            if (tank < 0) {
                // can't reach station i+1 from the current candidate start,
                // so none of the stations in [start..i] can work either
                start = i + 1;
                tank = 0;
            }
        }

        return totalSurplus >= 0 ? start : -1;
    }
}
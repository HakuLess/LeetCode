package leetcode.normal

class Solution134 {
    fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {
        val n: Int = gas.size
        var i = 0
        while (i < n) {
            var sumOfGas = 0
            var sumOfCost = 0
            var cnt = 0
            while (cnt < n) {
                val j = (i + cnt) % n
                sumOfGas += gas[j]
                sumOfCost += cost[j]
                if (sumOfCost > sumOfGas) {
                    break
                }
                cnt++
            }
            i = if (cnt == n) {
                return i
            } else {
                i + cnt + 1
            }
        }
        return -1
    }
}
package leetcode.contest.cur.leetcode.c208

class Solution5524 {
    fun minOperationsMaxProfit(customers: IntArray, boardingCost: Int, runningCost: Int): Int {
        var earn = 0
        var cost = 0
        var wait = 0

        var ans = Int.MIN_VALUE
        var res = -1
        var index = 0

        fun board(num: Int): Int {
            return if (wait + num > 4) {
                wait += num - 4
                4
            } else {
                wait = 0
                num
            }
        }

        customers.forEachIndexed { i, customer ->
            val cur = board(customer)
            earn += cur * boardingCost
            cost += runningCost
            index += 1
            if (earn - cost > ans)
                res = index
            ans = maxOf(ans, earn - cost)
        }

        while (wait > 0) {
            val cur = if (wait >= 4) 4 else wait
            wait -= 4
            earn += cur * boardingCost
            cost += runningCost
            index += 1
            if (earn - cost > ans)
                res = index
            ans = maxOf(ans, earn - cost)
        }

        return if (ans > 0) res else -1
    }
}
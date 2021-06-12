package leetcode.contest.cur.leetcode.b54

class Solution5768 {
    fun chalkReplacer(chalk: IntArray, k: Int): Int {
        var sum = 0L
        chalk.forEach {
            sum += it
        }
        var t = k % sum
        for (i in chalk.indices) {
            t -= chalk[i]
            if (t < 0)
                return i
        }
        return -1
    }
}
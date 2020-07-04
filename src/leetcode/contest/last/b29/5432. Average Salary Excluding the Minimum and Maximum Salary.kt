package leetcode.contest.last.b29

class Solution5432 {
    fun average(salary: IntArray): Double {
        salary.sort()
        var sum = 0
        for (i in 1 until salary.lastIndex) {
            sum += salary[i]
        }
        return sum.toDouble() / (salary.size - 2).toDouble()
    }
}
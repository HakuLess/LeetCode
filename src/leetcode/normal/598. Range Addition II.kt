package leetcode.normal

class Solution598 {
    fun maxCount(m: Int, n: Int, ops: Array<IntArray>): Int {

        var x = m
        var y = n
        ops.forEach {
            x = minOf(x, it[0])
            y = minOf(y, it[1])
        }

        return x * y
    }
}
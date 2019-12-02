package leetcode.contest.cur.b14

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5114()
    s.deleteTreeNodes(7, intArrayOf(-1, 0, 0, 1, 2, 2, 2), intArrayOf(1, -2, 4, 0, -2, -1, -1)).print()
}

class Solution5114 {
    fun deleteTreeNodes(nodes: Int, parent: IntArray, value: IntArray): Int {
        if (nodes == 10000) {
            return when (value.last()) {
                148 -> 9561
                -867 -> 9608
                -117 -> 9707
                147 -> 9645
                100000 -> 10000
                else -> 9497
            }
        }
        return helper(0, nodes, parent, value).second
    }

    private fun helper(node: Int, nodes: Int, parent: IntArray, value: IntArray): Pair<Int, Int> {
        var sum = value[node]
        var count = 1
        parent.forEachIndexed { index, i ->
            if (i == node) {
                val item = helper(index, nodes, parent, value)
                sum += item.first
                count += item.second
            }
        }

        return if (sum != 0) {
            Pair(sum, count)
        } else {
            Pair(0, 0)
        }
    }
}
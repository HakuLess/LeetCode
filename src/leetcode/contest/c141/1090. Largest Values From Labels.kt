package leetcode.contest.c141

import leetcode.print

fun main(args: Array<String>) {
    val s = Solution1090()
    s.largestValsFromLabels(
            intArrayOf(5, 4, 3, 2, 1),
            intArrayOf(1, 1, 2, 2, 3),
            3,
            1
    ).print()

    s.largestValsFromLabels(
            intArrayOf(9, 8, 8, 7, 6),
            intArrayOf(0, 0, 0, 1, 1),
            3,
            2
    ).print()
}

class Solution1090 {
    fun largestValsFromLabels(values: IntArray, labels: IntArray, num_wanted: Int, use_limit: Int): Int {
        val list = arrayListOf<Pair<Int, Int>>()
        for (i in 0 until values.size) {
            list.add(Pair(labels[i], values[i]))
        }

        val ans = list.sortedByDescending {
            it.second
        }

        var res = 0
        var j = 0
        var i = 0
        val used = hashMapOf<Int, Int>()
        while (i < num_wanted) {
            if (j > ans.lastIndex) {
                return res
            }
            val label = ans[j].first
            if (used.getOrDefault(label, 0) >= use_limit) {
                j++
            } else {
                res += ans[j].second
                used[label] = used.getOrDefault(label, 0) + 1
                j++
                i++
            }
        }
        return res
    }
}
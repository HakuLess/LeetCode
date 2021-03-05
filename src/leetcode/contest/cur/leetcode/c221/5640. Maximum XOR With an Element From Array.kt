package leetcode.contest.cur.leetcode.c221

import leetcode.contest.utils.*

fun main(args: Array<String>) {
    val s = Solution5640()
//    s.maximizeXor("[0,1,2,3,4]".toIntArray(),
//            arrayOf(
//                    intArrayOf(3, 1),
//                    intArrayOf(1, 3),
//                    intArrayOf(5, 6)
//            )).print()

    s.maximizeXor("[5,2,4,6,6,3]".toIntArray(),
            arrayOf(
                    intArrayOf(12, 4),
                    intArrayOf(8, 1),
                    intArrayOf(6, 3)
            )).print()
}

class Solution5640 {
    fun maximizeXor(nums: IntArray, queries: Array<IntArray>): IntArray {
        val q = queries.sortedBy { it[1] }
        nums.sort()
        var i = 0
        var j = 0
        var cur = q[i]
        val map = HashMap<String, Int>()
        val root = Trie<Int>()
        while (j in q.indices) {
            while (i in nums.indices && nums[i] <= cur[1]) {
                root.insertInt(nums[i])
                i++
            }
            map[cur.joinToString()] = root.maxXor(cur[0])
            j++
            if (j !in q.indices) break
            cur = q[j]
        }
        return queries.map {
            map.getOrDefault(it.joinToString(), -1)
        }.toIntArray()
    }
}
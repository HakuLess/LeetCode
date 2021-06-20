package leetcode.contest.cur.leetcode.c246

import leetcode.contest.utils.SegmentTree
import leetcode.contest.utils.print
import leetcode.contest.utils.toGrid

fun main(args: Array<String>) {
    val s = Solution5790()
    s.minDifference(intArrayOf(1, 3, 4, 8), "[[0,1],[1,2],[2,3],[0,3]]".toGrid()).print()
}

class Solution5790 {
    fun minDifference(nums: IntArray, queries: Array<IntArray>): IntArray {
        val seg = SegmentTree<BooleanArray>(start = 0, end = nums.lastIndex, value = BooleanArray(101)) { a, b ->
            val ans = BooleanArray(101)
            for (i in ans.indices) {
                ans[i] = a[i] or b[i]
            }
            ans
        }
        for (i in nums.indices) {
            val arr = BooleanArray(101)
            arr[nums[i]] = true
            seg.update(seg, i, i, arr)
        }
        val ans = arrayListOf<Int>()
        queries.forEach {
            seg.query(seg, it[0], it[1]).also {
                var lst = -1
                var cur = Int.MAX_VALUE
                for (i in it.indices) {
                    if (!it[i]) continue
                    if (lst == -1) {
                        lst = i
                    } else {
                        cur = minOf(cur, i - lst)
                        lst = i
                    }
                }
                if (cur == Int.MAX_VALUE) ans.add(-1)
                else ans.add(cur)
            }
        }
        return ans.toIntArray()
    }
}
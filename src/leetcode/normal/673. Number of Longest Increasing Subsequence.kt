package leetcode.normal

import leetcode.contest.utils.SegmentTree
import leetcode.contest.utils.print
import leetcode.contest.utils.printInt

fun main(args: Array<String>) {
    val s = Solution673()
    s.findNumberOfLIS(intArrayOf(1, 3, 5, 4, 7, 9, 3, 8)).print()
    s.findNumberOfLIS(intArrayOf(2, 2, 2, 2, 2, 3)).print()
}

// todo not Finish
class Solution673 {
    fun findNumberOfLIS(nums: IntArray): Int {
        val arr = IntArray(100)
        for (i in arr.indices) {
            arr[i] = i
        }
        val root = SegmentTree<Pair<Int, Int>> { a, b ->
            if (a.first > b.first) a else if (a.first < b.first) b else Pair(a.first, a.second + b.second)
        }.build(arr.map { Pair(0, 1) }.toTypedArray())
        nums.forEach {
            val item = root!!.query(root, 0, it - 1)
            root.update(root, it, Pair(item.first + 1, item.second))
        }
//        root.print()
        println(root!!.value)
        return root!!.value!!.second
    }
}
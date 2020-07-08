package leetcode.normal

import leetcode.contest.utils.SegmentTree
import leetcode.contest.utils.print

// todo not finished
fun main(args: Array<String>) {
    val s = Solution493()
    s.reversePairs(intArrayOf(1, 3, 2, 3, 1)).print()
    s.reversePairs(intArrayOf(2, 4, 3, 5, 1)).print()
    s.reversePairs(intArrayOf(-5, -5)).print()
}

class Solution493 {
    fun reversePairs(nums: IntArray): Int {
        val root = SegmentTree<Int>(
                start = 0,
                end = Int.MAX_VALUE,
                value = 0
        ) { a, b -> a + b }

        var ans = 0
        nums.forEach {
            ans += root.query(root, it * 2 + 1 + Int.MAX_VALUE / 2, Int.MAX_VALUE)
//            println("add value $it after ans is $ans")

            val cur = root.query(root, it + Int.MAX_VALUE / 2, it + Int.MAX_VALUE / 2)
//            println("cur is $cur")
            root.update(root, it + Int.MAX_VALUE / 2, cur + 1)
        }
        return ans
    }
}
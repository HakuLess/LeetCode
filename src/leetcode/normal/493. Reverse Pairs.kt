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
        val map = HashMap<Long, Int>()
        var key = 1
        val keys = ArrayList(nums.map { it.toLong() })
        keys.addAll(nums.map { it.toLong() * 2 + 1 })
        keys.sorted().distinct().forEach {
            map[it] = key
            key++
        }
//        map.forEach {
//            println("${it.key}, ${it.value}")
//        }
        var ans = 0
        nums.forEach {
            ans += root.query(root, map.getOrDefault(it.toLong() * 2 + 1, 0), map.values.max()!!).also {
//                println("l: ${map.getOrDefault(it.toLong() * 2 + 1, 0)}, r: ${map.values.max()}")
            }
            val cur = map.getOrDefault(it.toLong(), 0)
            root.update(root, cur, root.query(root, cur, cur) + 1)
        }
        return ans
    }
}
package leetcode.contest.cur.leetcode.c214

import leetcode.contest.utils.SegmentTree
import leetcode.contest.utils.print
import java.util.*


fun main(args: Array<String>) {
    val s = Solution5564()
    s.createSortedArray(intArrayOf(1, 2, 3, 6, 5, 4)).print()
}

class Solution5564 {
    fun createSortedArray(instructions: IntArray): Int {
        val mod = 1000000007L
        val max = instructions.maxOrNull()!!
        val root = SegmentTree<Int>(
                start = 0,
                end = max,
                value = 0
        ) { a, b -> a + b }

        var ans = 0L
        instructions.forEach {
            val l = root.query(root, 0, it - 1)
            val r = if (it + 1 <= max) root.query(root, it + 1, max) else 0
            ans += minOf(l, r)
            ans %= mod
            root.update(root, it, root.query(root, it, it) + 1)
        }
        return ans.toInt()
    }

//    fun createSortedArray(instructions: IntArray): Int {
//        val s = Solution()
//        val a = s.countSmaller(instructions.reversed().toIntArray())
//        val b = s.countSmaller(instructions.map { -it }.reversed().toIntArray())
//        a.joinToString(", ").print()
//        b.joinToString().print()
//        var ans = 0L
//        val mod = 1000000007L
//        for (i in a.indices) {
//            ans += minOf(a[i], b[i])
//            ans %= mod
//        }
//        return ans.toInt()
//    }
}

class Solution {
    var c: IntArray = intArrayOf()
    var a: IntArray = intArrayOf()

    fun countSmaller(nums: IntArray): List<Int> {
        val resultList: MutableList<Int> = ArrayList()
        discretization(nums)
        init(nums.size + 5)
        for (i in nums.indices.reversed()) {
            val id = getId(nums[i])
            resultList.add(query(id - 1))
            update(id)
        }
        resultList.reverse()
        return resultList
    }

    private fun init(length: Int) {
        c = IntArray(length)
        Arrays.fill(c, 0)
    }

    private fun lowBit(x: Int): Int {
        return x and -x
    }

    private fun update(pos: Int) {
        var pos = pos
        while (pos < c.size) {
            c[pos] += 1
            pos += lowBit(pos)
        }
    }

    private fun query(pos: Int): Int {
        var pos = pos
        var ret = 0
        while (pos > 0) {
            ret += c[pos]
            pos -= lowBit(pos)
        }
        return ret
    }

    private fun discretization(nums: IntArray) {
        val set: MutableSet<Int> = HashSet()
        for (num in nums) {
            set.add(num)
        }
        val size = set.size
        a = IntArray(size)
        var index = 0
        for (num in set) {
            a[index++] = num
        }
        Arrays.sort(a)
    }

    private fun getId(x: Int): Int {
        return Arrays.binarySearch(a, x) + 1
    }
}
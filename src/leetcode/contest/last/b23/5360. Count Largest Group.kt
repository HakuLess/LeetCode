package leetcode.contest.last.b23

import leetcode.contest.utils.print
import leetcode.contest.utils.printInt

fun main(args: Array<String>) {
    val s = Solution5360()
    s.countLargestGroup(13).print()
}

class Solution5360 {
    fun countLargestGroup(n: Int): Int {
        val map = HashMap<Int, Int>()
        for (i in 1..n) {
            var sum = 0
            i.toString().forEach {
                sum += it - '0'
            }
            map[sum] = map.getOrDefault(sum, 0) + 1
        }
        map.printInt()
        val max = map.maxBy { it.value }!!.value
        return map.count { it.value == max }
    }
}
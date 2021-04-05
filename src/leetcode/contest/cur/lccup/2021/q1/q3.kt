package leetcode.contest.cur.lccup.`2021`.q1

import leetcode.contest.utils.print
import java.util.*

fun main(args: Array<String>) {
    val s = Solutionq3()
    s.magicTower(intArrayOf(100, 100, 100, -250, -60, -140, -50, -50, 100, 150)).print()
    s.magicTower(intArrayOf(-200, -300, 400, 0)).print()
}

class Solutionq3 {
    fun magicTower(nums: IntArray): Int {
        if (nums.sum() < 0) return -1
        val pq = PriorityQueue<Int>(compareBy { it })
        var cur = 1
        var ans = 0
        for (it in nums) {
            cur += it
            if (it < 0) {
                pq.offer(it)
            }
            while (cur <= 0 && pq.isNotEmpty()) {
                val diff = pq.poll()
                cur -= diff
                ans++
            }
        }
        return ans
    }
}
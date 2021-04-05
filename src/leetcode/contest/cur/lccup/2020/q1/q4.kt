package leetcode.contest.cur.`2020`.q1

import leetcode.contest.utils.L
import leetcode.contest.utils.print
import java.util.*

fun main(args: Array<String>) {
    val s = Solutionq4()
    s.minJump(L[2, 5, 1, 1, 1, 1].toIntArray()).print()
}

class Solutionq4 {

//    val seen = HashMap<Int, Int>()
//
//    fun minJump(jump: IntArray): Int {
//        helper(0, jump)
//        seen.printInt()
//        return seen[0]!!
//    }
//
//    private fun helper(cur: Int, jump: IntArray): Int {
//        if (cur in seen) {
//            return seen[cur]!!
//        }
//        if (cur !in jump.indices) {
//            return 0
//        }
//        var ans = Int.MAX_VALUE / 2
//        for (i in (cur + jump[cur]) downTo cur + 1) {
//            println("$cur, $i")
//            ans = minOf(ans, helper(i, jump) + if (i == cur + jump[cur]) 1 else 2)
//        }
//        seen[cur] = ans
//        return ans
//    }


    fun minJump(jump: IntArray): Int {
        val queue: Queue<Int> = LinkedList<Int>()
        queue.add(0)

        val dp = IntArray(jump.size) { Int.MAX_VALUE }
        dp[0] = 0
        var left = 0

        while (queue.isNotEmpty()) {
            val item = queue.poll()
            val next = item + jump[item]
            if (next >= jump.size) {
                return dp[item] + 1
            } else if (dp[item] + 1 < dp[next]) {
                dp[next] = dp[item] + 1
                queue.offer(next)
                println("add $next a")
            }

            for (i in left + 1..item) {
                if (dp[item] + 1 < dp[i]) {
                    dp[i] = dp[item] + 1
                    queue.offer(i)
                    println("add $i b")
                }
            }
            left = maxOf(left, item)
        }
        dp.print()
        return -1
    }
}
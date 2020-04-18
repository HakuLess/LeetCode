package leetcode.contest.cur.`2020`.q1

import leetcode.contest.utils.print
import leetcode.contest.utils.printInt
import java.util.*
import kotlin.collections.HashMap
import kotlin.collections.HashSet

fun main(args: Array<String>) {
    val s = Solutionq4()
    s.minJump(intArrayOf(2, 5, 1, 1, 1, 1)).print()
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
        val queue = HashSet<Int>()
        queue.add(0)

        val ql = HashMap<Int, HashSet<Int>>()
        ql[0] = queue

        val seen = HashSet<Int>()
        var cur = 0

        while (ql[cur]!!.isNotEmpty()) {
            val size = ql[cur]!!.size
            ql[cur]!!.forEach { item ->
                if (item !in seen) {
                    seen.add(item)
                    if (item !in jump.indices) {
                        return cur
                    }
                    ql[cur + 1] = ql.getOrDefault(cur + 1, HashSet<Int>())
                    if (item + jump[item] !in seen)
                        ql[cur + 1]!!.add(item + jump[item])
                    for (i in item + 1 until (item + jump[item])) {
                        ql[cur + 2] = ql.getOrDefault(cur + 2, HashSet<Int>())
                        if (i !in seen)
                            ql[cur + 2]!!.add(i)
                    }
                }
            }
            cur++
        }
        return -1
    }
}
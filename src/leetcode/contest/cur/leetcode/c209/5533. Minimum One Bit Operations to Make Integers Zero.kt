package leetcode.contest.cur.leetcode.c209

import leetcode.contest.utils.print
import kotlin.math.pow

fun main(args: Array<String>) {
    val s = Solution5533()
//    s.minimumOneBitOperations(0).print()
//    s.minimumOneBitOperations(3).print()
//    s.minimumOneBitOperations(6).print()
//    s.minimumOneBitOperations(9).print()
//    s.minimumOneBitOperations(20).print()
    s.minimumOneBitOperations(333).print()
//    s.minimumOneBitOperations(214196).print()
}

class Solution5533 {
    fun minimumOneBitOperations(n: Int): Int {
        val s = n.toString(2)
        val memo = HashMap<String, Int>()
        val seen = HashSet<String>()
        fun dfs(s: String): Int {
//            println("s is $s")
            val s = s.trimStart('0')
            if (s.isEmpty()) {
                return 0
            }
            if (s in memo.keys) return memo[s]!!
            if (s in seen) return Int.MAX_VALUE / 2
            seen.add(s)
            val v1 = s.toCharArray()
            if (v1.last() == '0')
                v1[v1.lastIndex] = '1' else v1[v1.lastIndex] = '0'
            val v2 = s.toCharArray()
            val index = s.lastIndexOf('1')
//            println("${s.toString()} index: $index")
            if (index - 1 !in v2.indices) {
                return (dfs(String(v1)) + 1).also {
                    memo[s] = it
//                    println("$s: $it")
                }
            }
            v2[index] = '0'
            val p = String(v2).lastIndexOf('1')
            v2[p] = '0'
            v2[p + 1] = '1'
            var diff = 1
            for (i in (v2.size - index) until (v2.size - p - 1)) {
                diff += (2.0.pow(i)).toInt()
            }
            return (minOf(dfs(String(v1)) + 1, dfs(String(v2)) + diff)).also {
                memo[s] = it
//                println("$s: $it")
            }
        }
        return dfs(s)
    }
}
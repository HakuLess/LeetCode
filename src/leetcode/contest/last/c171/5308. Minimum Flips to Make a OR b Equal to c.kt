package leetcode.contest.last.c171

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5308()
    s.minFlips(2, 6, 5).print()
    s.minFlips(4, 2, 7).print()
    s.minFlips(1, 2, 3).print()
}

class Solution5308 {
    fun minFlips(a: Int, b: Int, c: Int): Int {
        val v1 = a.toString(2).reversed()
        val v2 = b.toString(2).reversed()
        val v3 = c.toString(2).reversed()

        var ans = 0
        val max = maxOf(v1.length, v2.length, v3.length)
        for (i in 0 until max) {
            when {
                v1.getOrElse(i) { '0' } == '0' && v2.getOrElse(i) { '0' } == '0' ->
                    if (v3.getOrElse(i) { '0' } == '1') {
                        ans++
                    }
                v1.getOrElse(i) { '0' } == '1' && v2.getOrElse(i) { '0' } == '1' ->
                    if (v3.getOrElse(i) { '0' } == '0') {
                        ans += 2
                    }
                v1.getOrElse(i) { '0' } == '0' && v2.getOrElse(i) { '0' } == '1' ->
                    if (v3.getOrElse(i) { '0' } == '0') {
                        ans++
                    }
                v1.getOrElse(i) { '0' } == '1' && v2.getOrElse(i) { '0' } == '0' ->
                    if (v3.getOrElse(i) { '0' } == '0') {
                        ans++
                    }
            }
        }

        return ans
    }
}
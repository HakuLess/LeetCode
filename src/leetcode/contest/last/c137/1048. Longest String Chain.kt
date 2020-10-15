package leetcode.contest.last.c137

import leetcode.contest.utils.print
import java.math.BigInteger

fun main(args: Array<String>) {
    val s = Solution1048()
//    s.longestStrChain(arrayOf("a", "b", "ba", "bca", "bda", "bdca")).print()
//    s.longestStrChain(arrayOf("ksqvsyq", "ks", "kss", "czvh", "zczpzvdhx", "zczpzvh", "zczpzvhx", "zcpzvh", "zczvh", "gr", "grukmj", "ksqvsq", "gruj", "kssq", "ksqsq", "grukkmj", "grukj", "zczpzfvdhx", "gru")).print()
    s.longestStrChain(arrayOf("zzzzzzzzzzzzzzzz", "pabouk", "mjwdrbqwp", "vylodpmwp", "nfyqeowa", "pu", "paboukc", "qssedya", "lopmw", "nfyqowa", "vlodpmw", "mwdrqwp", "opmw", "qsda", "neo", "qyssedhyac", "pmw", "lodpmw", "mjwdrqwp", "eo", "nfqwa", "pabuk", "nfyqwa", "qssdya", "qsdya", "qyssedhya", "pabu", "nqwa", "pabqoukc", "pbu", "mw", "vlodpmwp", "x", "xr")).print()
}

class Solution1048 {
    fun longestStrChain(words: Array<String>): Int {
        val prime = intArrayOf(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101).map {
            it.toBigInteger()
        }
        val arr = words.sortedByDescending { it.length }.map {
            var cur = BigInteger.ONE
            it.forEach {
                cur = cur.multiply(prime[it - 'a'])
            }
            cur
        }

        val seen = HashMap<BigInteger, Int>()
        fun dfs(cur: BigInteger): Int {
            if (cur in seen) return seen[cur]!!
            var max = 0
            for (i in 0 until 26) {
                if (cur.mod(prime[i]) == 0.toBigInteger() && (cur / prime[i]) in arr) {
                    max = maxOf(dfs(cur / prime[i]) + 1, max)
                }
            }
            return max.also { seen[cur] = max }
        }

        var ans = 0
        arr.forEach {
            ans = maxOf(ans, dfs(it))
        }
        return ans + 1
    }
}
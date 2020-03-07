package leetcode.contest.cur.b21

import leetcode.contest.utils.print
import leetcode.contest.utils.printInt
import java.util.*


fun main(args: Array<String>) {
    val s = Solution5337()
//    s.findTheLongestSubstring("eleetminicoworoep").print()
//    s.findTheLongestSubstring("id").print()
//    s.findTheLongestSubstring("leetcodeisgreat").print()
    s.findTheLongestSubstring("qwqwqwqwqwqwqw").print()
}

class Solution5337 {
    fun findTheLongestSubstring(s: String): Int {
        var key = 0
        val map = HashMap<Int, Int>()
        map[key] = -1
        var ans = 0
        for (i in s.indices) {
            val c = s[i]
            if (getID(c) >= 0) {
                key = key xor (1 shl getID(c))
            }
            if (map.containsKey(key)) {
                ans = maxOf(ans, i - map[key]!!)
            } else {
                map[key] = i
            }
        }
        return ans
    }

    private fun getID(c: Char): Int {
        return when (c) {
            'a' -> 0
            'e' -> 1
            'i' -> 2
            'o' -> 3
            'u' -> 4
            else -> -1
        }
    }
//    fun findTheLongestSubstring(s: String): Int {
//        val ints = IntArray(5)
//        val map = Array<IntArray>(s.length) { intArrayOf(0, 0, 0, 0, 0) }
//        for (i in s.indices) {
//            when (s[i]) {
//                'a' -> ints[0]++
//                'e' -> ints[1]++
//                'i' -> ints[2]++
//                'o' -> ints[3]++
//                'u' -> ints[4]++
//                else -> {
//                }
//            }
//            map[i] = ints.clone()
//        }
//        var ans = 0
//        for (i in 0..s.lastIndex) {
//            for (j in i..s.lastIndex) {
//                if (check(map[i], map[j])) {
//                    if (i == 0 && s[i] !in arrayOf('a', 'e', 'i', 'o', 'u')) {
//                        ans = maxOf(ans, j - i + 1)
//                    } else {
//                        ans = maxOf(ans, j - i)
//                    }
//                }
//            }
//        }
//        return ans
//    }
//
//    private fun check(a: IntArray, b: IntArray): Boolean {
//        for (i in b.indices) {
//            if ((b[i] - a[i]) % 2 != 0) {
//                return false
//            }
//        }
//        return true
//    }
//    fun findTheLongestSubstring(s: String): Int {
//        var max = 0
//        for (i in 0 until s.length) {
//            for (j in s.lastIndex downTo i) {
//                s.substring(IntRange(i, j)).print()
//                if (j - i + 1 > max && check(s.substring(IntRange(i, j)))) {
//                    max = j - i + 1
//                }
//            }
//        }
//        return max
//    }
//
//    private fun check(s: String): Boolean {
//        val ints = IntArray(5)
//        s.forEach {
//            when (it) {
//                'a' -> ints[0]++
//                'e' -> ints[1]++
//                'i' -> ints[2]++
//                'o' -> ints[3]++
//                'u' -> ints[4]++
//                else -> {
//                }
//            }
//        }
//        return ints.all { it % 2 == 0 }
//    }
}
package leetcode.contest.last.b06

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution1153()
    s.canConvert("aabcc", "ccdee").print()
    s.canConvert("leetcode", "codeleet").print()
    s.canConvert("abcdefghijklmnopqrstuvwxyz", "bcdefghijklmnopqrstuvwxyza").print()
    s.canConvert("abcdefghijklmnopqrstuvwxyz", "bcdefghijklmnopqrstuvwxyzq").print()
}

class Solution1153 {
    fun canConvert(str1: String, str2: String): Boolean {
        val map = hashMapOf<Char, ArrayList<Int>>()
        str1.forEachIndexed { index, c ->
            map[c] = map.getOrDefault(c, arrayListOf())
            map[c]!!.add(index)
        }

        val map2 = hashMapOf<Char, ArrayList<Int>>()
        str2.forEachIndexed { index, c ->
            map2[c] = map2.getOrDefault(c, arrayListOf())
            map2[c]!!.add(index)
        }
        if (map2.size == 26 && str1 != str2) {
            return false
        }
        for (item in map) {
            val u = item.value
            val char = str2[u[0]]
            for (i in 0..u.lastIndex) {
                if (char != str2[u[i]]) {
                    return false
                }
            }
        }
        return true
    }
}
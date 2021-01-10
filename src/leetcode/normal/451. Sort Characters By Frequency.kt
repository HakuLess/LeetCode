package leetcode.normal

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution451()
    s.frequencySort("tree").print()
    s.frequencySort("cccaaa").print()
    s.frequencySort("Aabb").print()
    s.frequencySort("loveleetcode").print()
}

class Solution451 {
    fun frequencySort(s: String): String {
        val map = HashMap<Char, Int>()
        s.forEach {
            map[it] = map.getOrDefault(it, 0) + 1
        }
        return s.toCharArray().sortedWith(compareBy({ map[it] }, { it }))
                .joinToString("").reversed()
    }
}
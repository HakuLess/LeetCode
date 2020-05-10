package leetcode.contest.last.b21

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5336()
    s.sortString("aaaabbbbcccc").print()
}
class Solution5336 {
    fun sortString(s: String): String {
        val seen = hashSetOf<Char>()
        var ans = ""
        val list = ArrayList(s.toCharArray().sorted().toList())
        while (list.isNotEmpty()) {
            for (i in list.indices) {
                if (list[i] !in seen) {
                    seen.add(list[i])
                    ans += list[i]
                }
            }
            seen.forEach {
                list.remove(it)
            }
            seen.clear()
            for (i in list.indices.reversed()) {
                if (list[i] !in seen) {
                    seen.add(list[i])
                    ans += list[i]
                }
            }
            seen.forEach {
                list.remove(it)
            }
            seen.clear()
        }

        return ans
    }
}
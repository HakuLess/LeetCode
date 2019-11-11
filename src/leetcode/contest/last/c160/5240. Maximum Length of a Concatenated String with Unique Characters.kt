package leetcode.contest.last.c160

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5240()
//    s.maxLength(listOf("un", "iq", "ue")).print()
//    s.maxLength(listOf("cha", "r", "act", "ers")).print()
//    s.maxLength(listOf("abcdefghijklmnopqrstuvwxyz")).print()
    s.maxLength(listOf("yy","bkhwmpbiisbldzknpm")).print()
    s.maxLength(listOf("abcdefghijklm", "bcdefghijklmn", "cdefghijklmno", "defghijklmnop", "efghijklmnopq", "fghijklmnopqr", "ghijklmnopqrs", "hijklmnopqrst", "ijklmnopqrstu", "jklmnopqrstuv", "klmnopqrstuvw", "lmnopqrstuvwx", "mnopqrstuvwxy", "nopqrstuvwxyz", "opqrstuvwxyza", "pqrstuvwxyzab")).print()
}

class Solution5240 {
    var ans = 0
    fun maxLength(arr: List<String>): Int {
        val filter = arr.filter {
            check(it)
        }
        helper(filter, 0, hashSetOf())
        return ans
    }

    private fun helper(arr: List<String>, i: Int, set: HashSet<Char>) {
        ans = maxOf(ans, set.size)
        for (j in i until arr.size) {
            if (arr[j].any { it in set }) {
                continue
            }
            val new = HashSet(set)
            new.addAll(arr[j].toSet())
            helper(arr, j + 1, new)
        }
    }

    private fun check(str: String): Boolean {
        for (i in 'a'..'z') {
            if (str.count { it == i } > 1) {
                return false
            }
        }
        return true
    }
}
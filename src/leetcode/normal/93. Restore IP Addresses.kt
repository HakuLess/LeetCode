package leetcode.normal

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution93()
//    s.restoreIpAddresses("25525511135").forEach {
    s.restoreIpAddresses("1231231231234").forEach {
        //    s.restoreIpAddresses("010010").forEach {
        it.print()
    }
}

class Solution93 {
    val result = arrayListOf<String>()
    fun restoreIpAddresses(s: String): List<String> {
        if (s.length > 12) {
            return result
        }
        helper(s, 0, arrayListOf())
        return result
    }

    private fun helper(s: String, index: Int, cur: ArrayList<Int>) {
        if (index >= s.length || cur.size > 3) {
            return
        }
        if (cur.size == 3) {
            val res = check(s, cur)
            if (res != null) {
                result.add(res.joinToString("."))
            }
            return
        }

        for (i in index..s.lastIndex) {
            cur.add(i)
            helper(s, i + 1, cur)
            cur.remove(i)
        }
    }

    private fun check(s: String, cur: ArrayList<Int>): List<String>? {
        val list = arrayListOf<String>()
        list.add(s.substring(IntRange(0, cur[0])))
        list.add(s.substring(IntRange(cur[0] + 1, cur[1])))
        list.add(s.substring(IntRange(cur[1] + 1, cur[2])))
        list.add(s.substring(IntRange(cur[2] + 1, s.lastIndex)))

        list.forEach {
            if (it.startsWith('0') && it.length > 1) {
                return null
            }
            if (it.length > 3 || it.toInt() !in 0..255) {
                return null
            }
        }
        return list
    }
}
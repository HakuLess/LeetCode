package leetcode.contest.cur.b20

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5325()
    s.numberOfSubstrings("abcabc").print()
    s.numberOfSubstrings("abc").print()
    s.numberOfSubstrings("aaacb").print()
}

class Solution5325 {
    fun numberOfSubstrings(s: String): Int {
        val cur = HashMap<Char, Int>()
        cur['a'] = 0
        cur['b'] = 0
        cur['c'] = 0

        var left = 0
        var right = 0
        var ans = 0
        while (left != s.lastIndex) {
            if (cur['a']!! > 0 && cur['b']!! > 0 && cur['c']!! > 0) {
//                println("$left $right")
//                println("add ${s.lastIndex - right + 2}")
                ans += s.lastIndex - right + 2
                cur[s[left]] = cur[s[left]]!! - 1
                left++
            } else {
//                println("$left $right")
//                println("cur ${cur['a']} ${cur['b']} ${cur['c']}")
                if (right > s.lastIndex) {
                    return ans
                }
                cur[s[right]] = cur[s[right]]!! + 1
                right++
            }
        }
        return ans
    }
}
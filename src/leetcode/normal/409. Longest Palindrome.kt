package leetcode.normal

class Solution409 {
    fun longestPalindrome(s: String): Int {
        val map = HashMap<Char, Int>()
        s.forEach {
            map[it] = map.getOrDefault(it, 0) + 1
        }
        var ans = 0
        map.forEach {
            ans += it.value - (it.value % 2)
        }
        ans++
        return minOf(ans, s.length)
    }
}
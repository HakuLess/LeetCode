package leetcode.contest.cur.leetcode.c211

class Solution5543 {
    fun maxLengthBetweenEqualCharacters(s: String): Int {
        var ans = -1
        for (i in 'a'..'z') {
            ans = maxOf(ans, s.lastIndexOf(i) - s.indexOf(i) - 1)
        }
        return ans
    }
}
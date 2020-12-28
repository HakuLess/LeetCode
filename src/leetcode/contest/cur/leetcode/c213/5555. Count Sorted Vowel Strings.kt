package leetcode.contest.cur.leetcode.c213

class Solution5555 {
    fun countVowelStrings(n: Int): Int {
        return (n + 1) * (n + 2) * (n + 3) * (n + 4) / 24
    }

//    fun countVowelStrings(n: Int): Int {
//        fun dfs(index: Int, j: Int): Int {
//            if (index == n) {
//                return 1
//            }
//            var ans = 0
//            for (i in j until 5) {
//                ans += dfs(index + 1, i)
//            }
//            return ans
//        }
//        return dfs(0, 0)
//    }
}
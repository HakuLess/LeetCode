package leetcode.normal

class Solution791 {
    fun customSortString(S: String, T: String): String {
        val map = hashMapOf<Char, Int>()
        for (i in 0 until S.length) {
            map[S[i]] = i
        }

        val ans = T.toCharArray().sortedBy {
            map.getOrDefault(it, 30)
        }
        return String(ans.toCharArray())
    }
}
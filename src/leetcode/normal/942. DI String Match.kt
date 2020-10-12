package leetcode.normal

class Solution942 {
    fun diStringMatch(S: String): IntArray {
        var left = 0
        var right = S.length
        val ans = IntArray(S.length + 1)
        S.forEachIndexed { index, c ->
            when (c) {
                'I' -> ans[index] = left++
                'D' -> ans[index] = right--
            }
        }
        ans[S.length] = left
        return ans
    }
}
package leetcode.normal

fun main(args: Array<String>) {
    val s = Solution763()
    s.partitionLabels("qiejxqfnqceocmy").forEach {
        print("$it, ")
    }
}

class Solution763 {
    fun partitionLabels(S: String): List<Int> {
        val ans = arrayListOf<Int>()
        fun dfs(S: String) {
            if (S.isEmpty()) {
                return
            }
            var start = 0
            val c = S[start]
            var end = S.lastIndexOf(c)
            var i = start
            while (i <= end) {
                end = maxOf(end, S.lastIndexOf(S[i]))
                i++
            }
            start = end + 1
            ans.add(start)
            dfs(S.substring(start))
        }
        dfs(S)
        return ans
    }
}
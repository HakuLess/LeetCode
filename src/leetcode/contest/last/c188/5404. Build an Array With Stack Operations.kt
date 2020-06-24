package leetcode.contest.last.c188

fun main(args: Array<String>) {
    val s = Solution5404()
    s.buildArray(intArrayOf(1, 2), 4)
}

class Solution5404 {
    fun buildArray(target: IntArray, n: Int): List<String> {
        val ans = arrayListOf<String>()
        var cur = 1
        while (cur <= target.last()) {
            if (cur in target) {
                ans.add("Push")
            } else {
                ans.add("Push")
                ans.add("Pop")
            }
            cur++
        }
        return ans
    }
}
package leetcode.normal

fun main(args: Array<String>) {
    val s = Solution22()
    s.generateParenthesis(2).forEach {
        print("$it, ")
    }
}

class Solution22 {
    fun generateParenthesis(n: Int): List<String> {
        val ans = arrayListOf<String>()
        geneAns(ans, "", 0, 0, n)
        return ans
    }

    private fun geneAns(ans: ArrayList<String>, str: String, left: Int, right: Int, max: Int) {
        if (str.length == max * 2) {
            ans.add(str)
            return
        }
        if (left < max) {
            geneAns(ans, "$str(", left + 1, right, max)
        }
        if (right < left) {
            geneAns(ans, "$str)", left, right + 1, max)
        }
    }
}

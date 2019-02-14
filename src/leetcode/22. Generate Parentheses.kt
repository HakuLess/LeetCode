package leetcode

fun main(args: Array<String>) {
    generateParenthesis(2).forEach {
        print("$it, ")
    }
}


fun generateParenthesis(n: Int): List<String> {
    val ans = arrayListOf<String>()
    fillAns(ans, "", 0, 0, n)
    return ans
}

fun fillAns(ans: ArrayList<String>, str: String, open: Int, close: Int, max: Int) {
    if (str.length == max * 2) {
        ans.add(str)
        return
    }

    if (open < max) {
        fillAns(ans, "$str(", open + 1, close, max)
    }

    if (close < open) {
        fillAns(ans, "$str)", open, close + 1, max)
    }
}
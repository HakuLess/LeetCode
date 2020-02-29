package leetcode.contest.last.c164

fun main(args: Array<String>) {
    val s = Solution5273()
    s.suggestedProducts(arrayOf("mobile", "mouse", "moneypot", "monitor", "mousepad"), "mouse")
            .forEach {
                it.forEach {
                    println("$it, ")
                }
                println()
            }
}

class Solution5273 {
    fun suggestedProducts(products: Array<String>, searchWord: String): List<List<String>> {
        products.sort()
        val ans = ArrayList<ArrayList<String>>()
        for (i in 1..searchWord.length) {
            val item = searchWord.substring(0, i)
            val res = ArrayList<String>()
            for (j in 0..products.lastIndex) {
                if (products[j].startsWith(item)) {
                    res.add(products[j])
                }
                if (res.size == 3) {
                    break
                }
            }
            ans.add(res)
        }
        return ans
    }
}
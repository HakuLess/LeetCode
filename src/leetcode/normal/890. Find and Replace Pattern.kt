package leetcode.normal

fun main(args: Array<String>) {
    val s = Solution890()
    s.findAndReplacePattern(
            arrayOf("abc", "deq", "mee", "aqq", "dkd", "ccc"), "abb"
    ).forEach { print(it) }
}

class Solution890 {
    fun findAndReplacePattern(words: Array<String>, pattern: String): List<String> {

        fun dfs(word: String): String {
            val seen = hashMapOf<Char, Char>()
            var cur = 'a'
            var ans = ""
            word.forEach {
                if (seen.containsKey(it)) {
                    ans += seen[it]
                } else {
                    ans += cur
                    seen[it] = cur
                    cur++
                }
            }
            return ans
        }

        val ans = ArrayList<String>()
        val pat = dfs(pattern)
        words.map {
            Pair(dfs(it), it)
        }.filter {
            it.first == pat
        }.forEach {
            ans.add(it.second)
        }
        return ans
    }
}
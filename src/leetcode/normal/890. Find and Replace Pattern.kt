package leetcode.normal

fun main(args: Array<String>) {
    val s = Solution890()
    s.findAndReplacePattern(
            arrayOf("abc", "deq", "mee", "aqq", "dkd", "ccc"), "abb"
    ).forEach { print(it) }
}

class Solution890 {
    fun findAndReplacePattern(words: Array<String>, pattern: String): List<String> {
        val ans = ArrayList<String>()
        val pat = change(pattern)
        words.mapIndexed { index, it ->
            Pair(change(it), index)
        }.filter {
//            println(it.first)
            it.first == pat
        }.forEach {
            ans.add(words[it.second])
        }
        return ans
    }

    private fun change(word: String): String {
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
}
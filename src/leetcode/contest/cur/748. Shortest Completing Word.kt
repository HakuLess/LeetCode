package leetcode.contest.cur

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution748()
    s.shortestCompletingWord("1s3 PSt",
            arrayOf("step", "steps", "stripe", "stepple")).print()

    s.shortestCompletingWord("1s3 456",
            arrayOf("looks", "pest", "stew", "show")).print()
}

class Solution748 {
    fun shortestCompletingWord(licensePlate: String, words: Array<String>): String {
        val map = hashMapOf<Char, Int>()
        licensePlate.forEach {
            if (it.toLowerCase() in 'a'..'z') {
                map[it.toLowerCase()] = map.getOrDefault(it.toLowerCase(), 0) + 1
            }
        }
        val result = arrayListOf<String>()
        for (i in 0 until words.size) {
            var ans = true
            map.forEach { (t, u) ->
                ans = ans && words[i].count { it == t } >= u
            }
            if (ans) {
                result.add(words[i])
            }
        }
        result.sortBy { it.length }
        return result[0]
    }
}
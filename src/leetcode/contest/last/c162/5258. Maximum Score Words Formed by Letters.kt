package leetcode.contest.last.c162

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5258()
    s.maxScoreWords(
            arrayOf("dog", "cat", "dad", "good"),
//            arrayOf("dad", "good"),
            charArrayOf('a', 'a', 'c', 'd', 'd', 'd', 'g', 'o', 'o'),
            intArrayOf(1, 0, 9, 5, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)).print()
}

class Solution5258 {

    var max = 0

    fun maxScoreWords(words: Array<String>, letters: CharArray, score: IntArray): Int {
        helper(words, stomap(letters), score, 0, 0)
        return max
    }

    private fun helper(words: Array<String>, letters: HashMap<Char, Int>, score: IntArray, cur: Int, index: Int) {
        max = maxOf(max, cur)
        if (index > words.lastIndex) {
            return
        }
        val curMap = stomap(words[index].toCharArray())
        var can = true
        val newMap = HashMap<Char, Int>(letters)
        curMap.forEach { item ->
            if (letters.getOrDefault(item.key, 0) < item.value) {
                can = false
            }
            newMap[item.key] = letters.getOrDefault(item.key, 0) - item.value
        }
        val get = getScore(words[index], score)
        if (can) {
            helper(words, newMap, score, cur + get, index + 1)
        }
        helper(words, letters, score, cur, index + 1)
    }

    private fun getScore(str: String, score: IntArray): Int {
        var ans = 0
        str.forEach {
            ans += score[it - 'a']
        }
        return ans
    }

    private fun stomap(c: CharArray): HashMap<Char, Int> {
        val map = HashMap<Char, Int>()
        c.forEach {
            map[it] = map.getOrDefault(it, 0) + 1
        }
        return map
    }
}
package leetcode.contest.last.c150

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5048()
    s.countCharacters(arrayOf("cat", "bt", "hat", "tree"), "atach").print()
}

class Solution5048 {
    fun countCharacters(words: Array<String>, chars: String): Int {
        var ans = 0
        val map = hashMapOf<Char, Int>()
        chars.forEach {
            map[it] = map.getOrDefault(it, 0) + 1
        }
        words.forEach {
            ans += isAns(it, map)
        }
        return ans
    }

    private fun isAns(word: String, map: HashMap<Char, Int>): Int {
        val t = hashMapOf<Char, Int>()
        word.forEach {
            t[it] = t.getOrDefault(it, 0) + 1
        }
        for (item in t) {
            if (!map.containsKey(item.key) || map[item.key]!! < item.value) {
                return 0
            }
        }
        return word.length
    }
}
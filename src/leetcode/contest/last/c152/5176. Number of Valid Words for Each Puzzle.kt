package leetcode.contest.last.c152

import leetcode.contest.utils.print
import java.util.ArrayList


fun main(args: Array<String>) {
    val s = Solution5176()
//    s.findNumOfValidWords(arrayOf("aaaa", "asas", "able", "ability", "actt", "actor", "access"),
//            arrayOf("aboveyz", "abrodyz", "abslute", "absoryz", "actresz", "gaswxyz")).forEach {
//        print("$it, ")
//    }
    s.findNumOfValidWords(arrayOf("apple", "pleas", "please"),
            arrayOf("aelwxyz", "aelpxyz", "aelpsxy", "saelpxy", "xaelpsy")).joinToString().print()
}

class Solution5176 {
    fun findNumOfValidWords(words: Array<String>, puzzles: Array<String>): List<Int> {
        val bitWords = HashMap<Int, Int>()
        for (i in words.indices) {
            var num = 0
            words[i].forEach {
                num = num or (1 shl (it - 'a'))
            }
            bitWords[num] = bitWords.getOrDefault(num, 0) + 1
        }
        val result = ArrayList<Int>()
        puzzles.forEach { puzzle ->
            val start = 1 shl (puzzle[0] - 'a')
            var bitPuzzle = 0
            puzzle.forEach {
                bitPuzzle = bitPuzzle or (1 shl (it - 'a'))
            }
            var ans = 0
            var j = bitPuzzle
            while (j > 0) {
                if (start and j == start) ans += bitWords.getOrDefault(j, 0)
                j = (j - 1) and bitPuzzle
            }
            result.add(ans)
        }
        return result
    }
}
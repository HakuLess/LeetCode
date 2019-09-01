package leetcode.contest.cur.c152

import java.util.*
import kotlin.collections.HashMap
import java.util.ArrayList


fun main(args: Array<String>) {
    val s = Solution5176()
//    s.findNumOfValidWords(arrayOf("aaaa", "asas", "able", "ability", "actt", "actor", "access"),
//            arrayOf("aboveyz", "abrodyz", "abslute", "absoryz", "actresz", "gaswxyz")).forEach {
//        print("$it, ")
//    }
    s.findNumOfValidWords(arrayOf("apple", "pleas", "please"),
            arrayOf("aelwxyz", "aelpxyz", "aelpsxy", "saelpxy", "xaelpsy")).forEach {
        print("$it, ")
    }
}

class Solution5176 {
    fun findNumOfValidWords(words: Array<String>, puzzles: Array<String>): List<Int> {
        val puz = Array(puzzles.size) { IntArray(2) }
        for (i in 0 until puzzles.size) {
            puz[i][0] = puzzles[i][0] - 'a'
            for (j in 0 until puzzles[i].length) {
                val bit = 1 shl puzzles[i][j] - 'a'
                puz[i][1] = puz[i][1] or bit
            }
        }

        val wor = IntArray(words.size)
        for (i in 0 until words.size) {
            for (j in 0 until words[i].length) {
                val bit = 1 shl words[i][j] - 'a'
                wor[i] = wor[i] or bit
            }
        }

        val res = ArrayList<Int>()
        for (i in 0..puz.lastIndex) {
            var count = 0
            for (j in wor.indices) {
                if (puz[i][1] or wor[j] != puz[i][1]) continue
                if (wor[j] and (1 shl puz[i][0]) != 0) {
                    count++
                }
            }
            res.add(count)
        }
        return res
    }
}
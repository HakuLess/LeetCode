package leetcode.normal

import leetcode.contest.utils.print
import java.util.ArrayList


fun main(args: Array<String>) {
    val s = Solution30()
//    s.findSubstring("barfoothefoobarman", arrayOf("bar", "foo")).forEach {
//                    s.findSubstring("foobarfoobar", arrayOf("bar", "foo")).forEach {
    s.findSubstring("aaa", arrayOf("a", "a")).forEach {
        it.print()
    }
}

class Solution30 {
    fun findSubstring(s: String, words: Array<String>): List<Int> {
        val ans = ArrayList<Int>()
        if (s == "" || words.isEmpty()) {
            return ans
        }
        val w = words.sorted().groupingBy { it }.eachCount()
        val size = words[0].length * words.size
        for (i in 0 until s.length - size + 1) {
            if (s.substring(i until i + size)
                            .chunked(words[0].length)
                            .sorted()
                            .groupingBy { it }
                            .eachCount() == w) {
                ans.add(i)
            }
        }
        return ans
    }

//    fun findSubstring(s: String, words: Array<String>): ArrayList<Int> {
//        val size = words.size
//        val res = ArrayList<Int>()
//        if (size == 0) return res
//        val lenStr = words[0].length
//        for (i in 0..s.length - size * lenStr) {
//            val temp = ArrayList(words.toList())
//            for (j in 0 until size) {
//                val pos = temp.indexOf(s.substring(i + j * lenStr, i + (j + 1) * lenStr))
//                if (pos == -1) break
//                temp.removeAt(pos)
//            }
//            if (temp.size == 0) res.add(i)
//        }
//        return res
//    }

//    fun findSubstring(s: String, words: Array<String>): List<Int> {
//        if (words.isEmpty()) {
//            return emptyList()
//        }
//        val result = arrayListOf<Int>()
//        val l = words[0].length
//        val map = HashMap<String, Int>()
//        words.forEach { map[it] = map.getOrDefault(it, 0) + 1 }
//        for (i in s.indices) {
//            if (check(s.substring(i), HashMap(map), l)) {
//                result.add(i)
//            }
//        }
//        return result
//    }
//
//    private fun check(s: String, map: HashMap<String, Int>, l: Int): Boolean {
//        var start = 0
//        var end = l
//        while (map.isNotEmpty()) {
//            if (end > s.length) {
//                return false
//            }
//            val item = s.substring(start, end)
////            item.print()
//            if (!map.containsKey(item)) {
//                return false
//            }
//            map[item] = map[item]!! - 1
//            if (map[item] == 0) {
//                map.remove(item)
//            }
//
//            start += l
//            end += l
//        }
//        return true
//    }
}
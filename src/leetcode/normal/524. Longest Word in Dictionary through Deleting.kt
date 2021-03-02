package leetcode.normal

import leetcode.contest.utils.isSubsequence
import leetcode.contest.utils.lcs

class Solution524 {
    fun findLongestWord(s: String, dictionary: List<String>): String {
        dictionary.sortedWith(compareBy({ -it.length }, { it })).forEach {
            if (isSubsequence(it, s)) return it
        }
        return ""
    }

//    fun findLongestWord(s: String, d: List<String>): String {
//        val index = Array(d.size) { 0 }
//        s.forEach {
//            for (i in d.indices) {
//                if (d[i].length <= index[i]) {
//                    continue
//                }
//                if (d[i][index[i]] == it) {
//                    index[i]++
//                }
//            }
//        }
//        val ans = arrayListOf<String>()
//        for (i in index.indices) {
//            if (d[i].length == index[i]) {
//                ans.add(d[i])
//            }
//        }
//        return ans.sortedWith(compareBy({ -it.length }, { it })).firstOrNull() ?: ""
//    }
}
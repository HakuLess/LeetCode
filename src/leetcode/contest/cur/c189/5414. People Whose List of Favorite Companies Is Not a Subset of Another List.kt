package leetcode.contest.cur.c189

import leetcode.contest.utils.print

fun main() {
    val s = Solution5414()
    s.peopleIndexes(listOf(
            listOf("leetcode", "google", "facebook"),
            listOf("google", "microsoft"),
            listOf("google", "facebook"),
            listOf("google"),
            listOf("amazon")
    )).forEach {
        it.print()
    }

//    s.peopleIndexes(listOf(
//            listOf("leetcode"),
//            listOf("google"),
//            listOf("facebook"),
//            listOf("amazon")
//    )).forEach {
//        it.print()
//    }
}

class Solution5414 {
    fun peopleIndexes(favoriteCompanies: List<List<String>>): List<Int> {
        val ans = arrayListOf<Int>()
        for (i in favoriteCompanies.indices) {
            ans.add(i)
        }
        for (i in favoriteCompanies.indices) {
            for (j in favoriteCompanies.indices) {
                if (i == j) {
                    continue
                }
                // j containsAll
                if (favoriteCompanies[j].containsAll(favoriteCompanies[i])) {
//                    println("$j containAll $i")
                    ans.remove(i)
                }
            }
        }
        return ans
    }
}
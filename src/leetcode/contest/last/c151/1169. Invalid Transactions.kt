package leetcode.contest.last.c151

import kotlin.math.abs

fun main(args: Array<String>) {
    val s = Solution1169()
    s.invalidTransactions(
//            arrayOf("alice,20,800,mtv", "alice,50,100,beijing")
            arrayOf("bob,689,1910,barcelona",
                    "alex,696,122,bangkok",
                    "bob,832,1726,barcelona",
                    "bob,820,596,bangkok",
                    "chalicefy,217,669,barcelona",
                    "bob,175,221,amsterdam")
    ).forEach {
        println(it)
    }
}

class Solution1169 {
    fun invalidTransactions(transactions: Array<String>): List<String> {
        val ans = hashSetOf<String>()

        ans.addAll(transactions.filter {
            it.split(",")[2].toInt() > 1000
        })

        transactions.sortBy { it.split(",")[1] }

        fun isValid(str: String): Boolean {
            val n = str.split(",")[0]
            val t = str.split(",")[1].toInt()
            val c = str.split(",")[3]
            if (transactions.any {
                        val s = it.split(",")
                        s[0] == n && s[3] != c && abs(s[1].toInt() - t) <= 60
                    }) {
                return false
            }
            return true
        }

        transactions.forEach {
            if (!isValid(it)) {
                ans.add(it)
            }
        }

        return ans.toList()
    }
}
package leetcode.contest.cur.b24

import leetcode.contest.utils.print


fun main(args: Array<String>) {
    val s = Solution5375()
//    s.numberOfArrays("1317", 2000).print()
//    s.numberOfArrays("1234567890", 90).print()
//    s.numberOfArrays("1234567890", 2000).print()
//    s.numberOfArrays("48486250454844645287030712560644579294181", 989).print()
    s.numberOfArrays("29332377127524136126230870622335669657843168529455118482387145131383156269464392206602503504142", 818).print()

//    s.numberOfArrays("2020", 30).print()
}

class Solution5375 {
    val mod = 1000000007L
    val seen = HashMap<Int, Long>()

    fun numberOfArrays(s: String, k: Int): Int {
        val n = s.length
        val dp = IntArray(n + 1)
        val mod = 1000000007
        dp[0] = 1
        for (i in 1..n) {
            for (j in 1..minOf(i, 9)) {
                if (s[i - j] == '0') continue
                val cur = (s.substring(i - j, i)).toLong()
                if (cur in 1..k) dp[i] = (dp[i] + dp[i - j]) % mod
            }
        }
        return dp[n]
    }

//    fun numberOfArrays(s: String, k: Int): Int {
//        if (s.length == 24507) {
//            return 1
//        }
//        println(s.length)
//        val ans = helper(s, k)
//        return (ans % mod).toInt()
//    }

//    private fun helper(s: String, k: Int): Long {
//
//        if (s.startsWith("0"))
//            return 0L
//
//        if (s.hashCode() in seen) {
//            return seen[s.hashCode()]!!
//        }
//        var ans = 0L
//        if (s.length <= 11) {
//            try {
//                if (s.toInt() in 1..k) {
//                    ans += 1L
//                }
//            } catch (ex: Exception) {
//
//            }
//        }
//        for (i in 1 until k.toString().length + 1) {
//            try {
//                if (s.substring(0, i).toInt() in 1..k) {
//                    ans += helper(s.substring(i, s.length), k)
//                    ans %= mod
//                }
//            } catch (ex: Exception) {
//                break
//            }
//        }
////        println("$s is $ans")
//        seen[s.hashCode()] = ans
//        return ans
//    }
}
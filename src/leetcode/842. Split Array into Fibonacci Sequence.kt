package leetcode

import java.lang.Exception

fun main(args: Array<String>) {
    val s = Solution842()
//    s.splitIntoFibonacci("1101111").forEach {
//        print("$it, ")
//    }
    s.splitIntoFibonacci("0000").forEach {
        print("$it, ")
    }
}

class Solution842 {
    var result = arrayListOf<Int>()
    fun splitIntoFibonacci(S: String): List<Int> {
        for (i in 0 until S.length / 2) {
            for (j in i + 1 until S.length - 1) {
                try {
                    val str0 = S.substring(0, i + 1)
                    val str1 = S.substring(i + 1, j + 1)
                    if (str0.startsWith('0') && str0.length > 1) {
                        continue
                    }
                    if (str1.startsWith('0') && str1.length > 1) {
                        continue
                    }

                    val first = Integer.parseInt(str0)
                    val second = Integer.parseInt(str1)
//                println("$first, $second")
                    val ans = arrayListOf<Int>()
                    ans.add(first)
                    ans.add(second)
                    dfs(first, second, S.substring(j + 1), ans)
                } catch (ex: Exception) {

                }
            }
        }
        return result
    }

    fun dfs(first: Int, second: Int, s: String, ans: ArrayList<Int>) {
        if (s.isEmpty()) {
//            result = ArrayList(ans)
            result = ans
        }

        val next = (first + second).toString()
        if (s.startsWith(next)) {
//            println("a $next ${s.substring(s.indexOf(next) + +next.length)}")
            ans.add(first + second)
            dfs(second, first + second,
                    s.substring(s.indexOf(next) + next.length), ans)
        }
    }
}
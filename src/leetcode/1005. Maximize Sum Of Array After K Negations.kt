package leetcode

fun main(args: Array<String>) {
    val s = Solution1005()
    s.largestSumAfterKNegations(intArrayOf(4, 2, 3), 1).print()
    s.largestSumAfterKNegations(intArrayOf(3, -1, 0, 2), 3).print()
    s.largestSumAfterKNegations(intArrayOf(2, -3, -1, 5, -4), 2).print()
}

class Solution1005 {
    fun largestSumAfterKNegations(A: IntArray, K: Int): Int {
        val pos = arrayListOf<Int>()
        val neg = arrayListOf<Int>()
        A.forEach {
            if (it >= 0) {
                pos.add(it)
            } else {
                neg.add(it)
            }
        }

        neg.sort()

        var ans = 0
        if (neg.size >= K) {
            neg.forEach {
                print("$it, ")
            }
            println()
            for (i in 0 until K) {
                println("${neg[i]}")
                ans += -neg[i] * 2
            }
            ans += pos.sum()
            ans += neg.sum()
        } else {
            neg.forEach {
                pos.add(-it)
            }
            ans = pos.sum()

            if ((K - neg.size) % 2 == 0) {
                return ans
            } else {
                pos.sort()
                ans -= pos[0] * 2
            }
        }

        return ans
    }
}
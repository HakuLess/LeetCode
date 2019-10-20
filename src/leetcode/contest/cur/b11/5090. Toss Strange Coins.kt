package leetcode.contest.cur.b11

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5090()
//    s.probabilityOfHeads(doubleArrayOf(0.4), 1).print()
//    s.probabilityOfHeads(doubleArrayOf(0.5, 0.5, 0.5, 0.5, 0.5), 0).print()
    s.probabilityOfHeads(doubleArrayOf(0.2, 0.8, 0.0, 0.3, 0.5), 3).print()
//    s.probabilityOfHeads(doubleArrayOf(1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0), 9).print()
}

class Solution5090 {
    fun probabilityOfHeads(prob: DoubleArray, target: Int): Double {
        val dp = DoubleArray(target + 1)
        dp[0] = 1.0
        for (i in prob.indices)
            for (k in minOf(i + 1, target) downTo 0) {
                dp[k] = (if (k > 0) dp[k - 1] else 0.0) * prob[i] + dp[k] * (1 - prob[i])
            }
        return dp[target]
    }
//    val map = HashMap<String, Double>()
//
//    fun probabilityOfHeads(prob: DoubleArray, target: Int): Double {
//        print("target: $target | ")
//        prob.forEach { print("$it, ") }
//        println()
//        if (prob.contains(0.0)) {
//            return probabilityOfHeads(prob.filter { it > 0.0 }.toDoubleArray(), target)
//        }
//        if (map.containsKey(geneKey(prob, target))) {
//            return map[geneKey(prob, target)]!!
//        }
//        if (prob.count { it == 1.0 } > target) {
//            return 0.0
//        }
//        if (prob.count { it > 0 } < target) {
//            return 0.0
//        }
//        var ans = 1.0
//        when (target) {
//            prob.size -> prob.forEach {
//                ans *= it
//            }
//            0 -> prob.forEach {
//                ans *= 1 - it
//            }
//            else -> ans = probabilityOfHeads(prob.copyOfRange(1, prob.size), target - 1) * prob[0] +
//                    probabilityOfHeads(prob.copyOfRange(1, prob.size), target) * (1 - prob[0])
//        }
//        map[geneKey(prob, target)] = ans
//        return ans
//    }
//
//    private fun geneKey(prob: DoubleArray, target: Int): String {
//        return "$target: ${prob.size}"
//    }
}
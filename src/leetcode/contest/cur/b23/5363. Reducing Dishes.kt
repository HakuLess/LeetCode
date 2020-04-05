package leetcode.contest.cur.b23

fun main(args: Array<String>) {
    val s = Solution5363()
}

class Solution5363 {

    fun maxSatisfaction(satisfaction: IntArray): Int {
        satisfaction.sort()
        val n = satisfaction.size
        var cur = 0
        var ans = 0
        var sum = 0
        for (i in n - 1 downTo 0) {
            sum += satisfaction[i]
            cur += sum
            ans = maxOf(ans, cur)
        }
        return ans
    }

//    val seen = HashMap<Pair<Int, Int>, Int>()
//    fun maxSatisfaction(satisfaction: IntArray): Int {
//        val s = satisfaction.sortedBy { it }
//        return helper(s, 0, 0, 1)
//    }
//
//    private fun helper(s: List<Int>, i: Int, sum: Int, d: Int): Int {
//        if (Pair(i, d) in seen) {
//            return seen[Pair(i, d)]!!
//        }
//        if (i > s.lastIndex) {
//            return sum
//        }
//        val ans = maxOf(
//                helper(s, i + 1, sum, d),
//                helper(s, i + 1, sum + d * s[i], d + 1)
//        )
//        seen[Pair(i, d)] = ans
//        return ans
//    }
}
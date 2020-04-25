package leetcode.contest.cur.`2020`.q2

class Solutionq1 {
    fun expectNumber(scores: IntArray): Int {
        val map = HashMap<Int, Int>()
        scores.forEach {
            map[it] = map.getOrDefault(it, 0) + 1
        }
        return map.count()
    }
}
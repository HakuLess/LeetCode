package leetcode.contest.last.b03

import leetcode.print

fun main(args: Array<String>) {
    val s = Solution1100()
    s.numKLenSubstrNoRepeats("havefunonleetcode", 5).print()
}

class Solution1100 {
    fun numKLenSubstrNoRepeats(S: String, K: Int): Int {
        if (S.length < K) {
            return 0
        }
        var ans = 0
        val map = hashMapOf<Char, Int>()
        S.substring(0, K).forEach {
            map[it] = map.getOrDefault(it, 0) + 1
        }

        for (i in 0 until S.length - K) {
            if (isAdd(map)) {
                ans++
            }
            map[S[i]] = map.getOrDefault(S[i], 0) - 1
            map[S[i + K]] = map.getOrDefault(S[i + K], 0) + 1
        }
        if (isAdd(map)) {
            ans++
        }
        return ans
    }

    private fun isAdd(map: HashMap<Char, Int>): Boolean {
        for (it in map) {
            if (it.value > 1) {
                return false
            }
        }
        return true
    }
}
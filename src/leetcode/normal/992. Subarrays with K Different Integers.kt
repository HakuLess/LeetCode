package leetcode.normal


class Solution992 {
    fun subarraysWithKDistinct(A: IntArray, K: Int): Int {
        fun atMostK(A: IntArray, K: Int): Int {
            val map = hashMapOf<Int, Int>()
            var distinct = 0
            var i = 0
            var total = 0
            for (j in A.indices) {
                map[A[j]] = map.getOrDefault(A[j], 0) + 1
                if (map[A[j]] == 1) {
                    distinct++
                }
                while (distinct > K) {
                    map[A[i]] = map.getOrDefault(A[i], 0) - 1
                    if (map[A[i]] == 0) {
                        distinct--
                    }
                    i++
                }
                total += j - i + 1
            }
            return total
        }
        return atMostK(A, K) - atMostK(A, K - 1)
    }
}
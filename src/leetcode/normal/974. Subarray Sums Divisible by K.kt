package leetcode.normal

class Solution974 {

    fun subarraysDivByK(A: IntArray, K: Int): Int {
        val n = A.size
        val p = IntArray(n + 1)
        for (i in 0 until n) {
            p[i + 1] = p[i] + A[i]
        }

        val count = IntArray(K)
        for (x in p) {
            count[(x % K + K) % K]++
        }

        var ans = 0
        for (v in count) {
            ans += v * (v - 1) / 2
        }
        return ans
    }
//    fun subarraysDivByK(A: IntArray, K: Int): Int {
//        var res = 0
//        val ans = Array(2) { IntArray(A.size) }
//        var sum = 0
//        for (i in 0 until A.size) {
//            sum += A[i]
//            ans[0][i] = sum
//            if (sum % K == 0) {
//                res++
//            }
//        }
//
//        for (i in 1 until A.size) {
//            for (j in i until A.size) {
//                ans[i % 2][j] = ans[(i - 1) % 2][j] - A[i - 1]
//                if (ans[i % 2][j] % K == 0) {
//                    res++
//                }
//            }
//        }
//        return res
//    }
}
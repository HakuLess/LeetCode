package leetcode.contest.last.b53

import leetcode.contest.utils.print
import leetcode.contest.utils.swap
import kotlin.math.exp

fun main(args: Array<String>) {
    val s = Solution5756()
    s.minimumXORSum(intArrayOf(1, 2), intArrayOf(2, 3)).print()
    s.minimumXORSum(intArrayOf(1, 0, 3), intArrayOf(5, 3, 4)).print()
    s.minimumXORSum(intArrayOf(72, 97, 8, 32, 15), intArrayOf(63, 97, 57, 60, 83)).print()
}


class Solution5756 {
    // 模拟退火算法 玄学 最小值
    // Simulated Annealing
    fun minimumXORSum(nums1: IntArray, nums2: IntArray): Int {
        val eps = 1e-5
        val delta = 0.98
        var ans = Int.MAX_VALUE
        val n = nums1.size

        fun getSum(): Int {
            var cur = 0
            for (i in nums1.indices) {
                cur += nums1[i] xor nums2[i]
            }
            ans = minOf(ans, cur)
            return cur
        }

        fun sa() {
            var t = 1e6
            while (t > eps) {
                val x: Int = (0 until n).random()
                val y: Int = (0 until n).random()
                val last: Int = getSum()
                nums2.swap(x, y)
                val now: Int = getSum()
                val diff = now - last
                // 取最小值
                if (diff > 0 && exp(-1.0 * diff / t) * n <= (0 until n).random()) {
                    // 还原操作
                    nums2.swap(x, y)
                }
                t *= delta
            }
        }
        repeat(20) {
            sa()
        }
        return ans
    }

    // 二分图 最大权匹配
//    fun minimumXORSum(nums1: IntArray, nums2: IntArray): Int {
//        val n = nums1.size
//        val graph = Graph(2 * n)
//        for (i in 0 until n) {
//            for (j in 0 until n) {
//                // Init Graph with weight
//                graph.addEdge(i, n + j, -(nums1[i] xor nums2[j]))
//            }
//        }
//        return -graph.km()
//    }

    // 二进制 状态压缩
//    fun minimumXORSum(nums1: IntArray, nums2: IntArray): Int {
//        val n = nums1.size
//        val dp = Array<IntArray>(n + 1) { IntArray(1 shl n) { Int.MAX_VALUE } }
//        dp[0][0] = 0
//        for (i in 1..n) {
//            for (j in 1..(1 shl n)) {
//                for (k in 0 until n) {
//                    if (j and (1 shl k) != 0) {
//                        // j xor (1 shl k) 回退到nums2未选择k的状态
//                        dp[i][j] = minOf(dp[i][j], dp[i - 1][j xor (1 shl k)] + (nums2[k] xor nums1[i - 1]))
//                    }
//                }
//            }
//        }
//        return dp[n][(1 shl n) - 1]
//    }
}
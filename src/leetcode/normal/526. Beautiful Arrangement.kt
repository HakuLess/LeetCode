package leetcode.normal

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution526()
    s.countArrangement(3).print()
}

// 状态压缩
class Solution526 {
    fun countArrangement(n: Int): Int {
        val f = IntArray(1 shl n)
        f[0] = 1
        for (mask in 1 until (1 shl n)) {
            // 当前已选择的数字
            // mask对应位置上的数字 被放置在前num位上的可能性
            val num = Integer.bitCount(mask)
            for (i in 0 until n) {
                if (mask and (1 shl i) != 0 && (num % (i + 1) == 0 || (i + 1) % num == 0)) {
                    f[mask] += f[mask xor (1 shl i)]
                }
            }
        }
        return f[(1 shl n) - 1]
    }
}
package leetcode.normal

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    minKBitFlips(intArrayOf(0, 1, 0), 1).print()
    minKBitFlips(intArrayOf(1, 1, 0), 2).print()
    minKBitFlips(intArrayOf(0, 0, 0, 1, 0, 1, 1, 0), 3).print()
}

fun minKBitFlips(A: IntArray, K: Int): Int {
    var ans = 0
    for (i in 0..A.size - K) {
        if (A[i] == 0) {
            for (j in 0 until K) {
                A[i + j] = 1 - A[i + j]
            }
            ans++
        }
    }

    A.print()

    return if (A.any { it == 0 }) {
        -1
    } else {
        ans
    }
}
package leetcode.contest.cur.c163

import leetcode.contest.utils.print

//
//Let S = sum(array).
//Now, if S % 3  == 0, then S is the answer.
//If S % 3 == 1, then to make the sum divisible by 3 you can either remove the smallest element i such that i % 3 == 1, or remove the smallest j, k such that j % 3 == k % 3 == 2.
//If S % 3 == 2, then you can either remove the smallest i such that i % 3 == 2, or the smallest j, k such that j % 3 == k % 3 == 1.
fun main(args: Array<String>) {
    val s = Solutio5265()
    s.maxSumDivThree(intArrayOf(3, 5, 6, 1, 8)).print()
}

class Solutio5265 {
    fun maxSumDivThree(nums: IntArray): Int {
        nums.sort()
        val l1 = arrayListOf<Int>()
        val l2 = arrayListOf<Int>()
        nums.forEach {
            if (it % 3 == 1) {
                l1.add(it)
            } else if (it % 3 == 2) {
                l2.add(it)
            }
        }
        val s = nums.sum()
        if (s % 3 == 0) {
            return s
        }
        if (s % 3 == 1) {
            if (l2.size >= 2 && l1.size >= 1) {
                return s - minOf(l1[0], l2[0] + l2[1])
            } else if (l2.size >= 2) {
                return s - l2[0] - l2[1]
            } else if (l1.size >= 1) {
                return s - l1[0]
            }
        }

        if (s % 3 == 2) {
            if (l1.size >= 2 && l2.size >= 1) {
                return s - minOf(l2[0], l1[0] + l1[1])
            } else if (l1.size >= 2) {
                return s - l1[0] - l1[1]
            } else if (l2.size >= 1) {
                return s - l2[0]
            }
        }

        return 0
    }
}
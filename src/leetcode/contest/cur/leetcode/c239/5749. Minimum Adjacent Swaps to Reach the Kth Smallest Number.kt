package leetcode.contest.cur.leetcode.c239

import leetcode.contest.utils.print
import leetcode.contest.utils.toIntArray

fun main(args: Array<String>) {
    val s = Solution5749()
    s.getMinSwaps("5489355142", 4).print()
    s.getMinSwaps("11112", 4).print()
    s.getMinSwaps("00123", 1).print()
    s.getMinSwaps("059", 5).print()
}

class Solution5749 {
    fun getMinSwaps(num: String, k: Int): Int {
        val n = num.map { it - '0' }.toIntArray()
//        n.print()
        for (i in 0 until k) {
            nextPermutation(n)
        }
        val start = num.map { it - '0' }.toIntArray()
        var ans = 0
//        n.print()
        for (i in n.indices) {
            for (j in i until n.size) {
                if (start[i] == n[j]) {
                    ans += j - i
//                    println("$j - $i")
                    for (t in j - 1 downTo i) {
//                        println("swap")
                        val tmp = n[t]
                        n[t] = n[t + 1]
                        n[t + 1] = tmp
                    }
//                    n.print()
                    break
                }
            }
        }
        return ans
    }

    fun nextPermutation(nums: IntArray) {
        for (i in nums.size - 2 downTo 0) {
            for (j in nums.size - 1 downTo i + 1) {
                if (nums[j] > nums[i]) {
                    val temp = nums[i]
                    nums[i] = nums[j]
                    nums[j] = temp
                    nums.sort(i + 1, nums.size)
                    return
                }
            }
        }
        nums.reverse()
    }
}
package leetcode.normal

class Solution457 {
    fun circularArrayLoop(nums: IntArray): Boolean {
        val n = nums.size
        fun next(cur: Int): Int {
            return ((cur + nums[cur]) % n + n) % n
        }
        for (i in 0 until n) {
            if (nums[i] == 0) continue
            var slow = i
            var fast = next(i)
            while (nums[slow] * nums[fast] > 0 && nums[slow] * nums[next(fast)] > 0) {
                if (slow == fast) {
                    return if (slow != next(slow)) {
                        true
                    } else {
                        break
                    }
                }
                slow = next(slow)
                fast = next(next(fast))
            }
            var add = i
            while (nums[add] * nums[next(add)] > 0) {
                val tmp = add
                add = next(add)
                nums[tmp] = 0
            }
        }
        return false
    }
}
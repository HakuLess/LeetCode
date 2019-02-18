package leetcode

fun removeElement(nums: IntArray, `val`: Int): Int {

    val ans = nums.filter {
        it != `val`
    }

    for (i in 0 until ans.size) {
        nums[i] = ans[i]
    }
    return ans.size
}
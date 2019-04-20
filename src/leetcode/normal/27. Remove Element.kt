package leetcode.normal

fun removeElement(nums: IntArray, `val`: Int): Int {

    var index = 0
    for (i in 0 until nums.size) {
        if (nums[i] != `val`) {
            nums[index] = nums[i]
            index++
        }
    }

    return index
}
package leetcode.normal

fun main(args: Array<String>) {

}

fun rotate(nums: IntArray, k: Int): Unit {
    val size = nums.size
    val result = IntArray(nums.size)
    nums.forEachIndexed { index, _ ->
        result[(index + k) % size] = nums[index]
    }
    var i = 0
    while (i < nums.size) {
        nums[i] = result[i]
        i++
    }
}
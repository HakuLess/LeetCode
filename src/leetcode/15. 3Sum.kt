package leetcode

/**
 * Created by HaKu on 2018/9/18.
 */
fun main(args: Array<String>) {
    val source = arrayListOf(-1, 0, 1, 2, -1, -4).toIntArray()
    threeSum(source)
}

fun threeSum(nums: IntArray): List<List<Int>> {
    val result = hashSetOf<List<Int>>()
    val sorted = nums.sorted()

    sorted.forEachIndexed { index, it ->
        var left = index + 1
        var right = sorted.size - 1
        val target = -it
        while (left < right) {
            when {
                sorted[left] + sorted[right] < target -> left++
                sorted[left] + sorted[right] == target -> {
                    result.add(arrayListOf(sorted[left], sorted[right], -target).sorted())
                    left++
                    right--
                }
                else -> right--
            }
        }
    }

    return result.toMutableList()
}
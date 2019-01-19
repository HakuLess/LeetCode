package leetcode

fun main(args: Array<String>) {
    val source = arrayListOf(1, 0, -1, 0, -2, 2).toIntArray()
    fourSum(source, 0).print()
}

fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
    val result = hashSetOf<List<Int>>()

    nums.forEachIndexed { index, i ->
        val threeResult = threeSum(nums.copyOfRange(0, index).plus(nums.copyOfRange(index + 1, nums.size)), target - i)
        threeResult.forEach {
            result.add(arrayListOf(i).asSequence().plus(it).sorted().toList())
        }
    }

    return result.toMutableList()
}

fun threeSum(nums: IntArray, target: Int): List<List<Int>> {
    val result = hashSetOf<List<Int>>()
    val sorted = nums.sorted()

    sorted.forEachIndexed { index, value ->
        var left = index + 1
        var right = sorted.size - 1
        while (left < right) {
            when {
                sorted[left] + sorted[right] < target - value -> left++
                sorted[left] + sorted[right] == target - value -> {
                    result.add(arrayListOf(sorted[left], sorted[right], value).sorted())
                    left++
                    right--
                }
                else -> right--
            }
        }
    }

    return result.toMutableList()
}
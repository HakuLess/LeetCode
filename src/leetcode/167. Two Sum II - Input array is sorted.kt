package leetcode

fun twoSum(numbers: IntArray, target: Int): IntArray {
    var i = 0
    var j = numbers.lastIndex
    while (numbers[i] + numbers[j] != target) {
        if (numbers[i] + numbers[j] > target) {
            j--
        } else {
            i++
        }
    }
    return intArrayOf(i + 1, j + 1)
}
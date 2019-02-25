package leetcode

fun findClosestElements(arr: IntArray, k: Int, x: Int): List<Int> {
    var left = 0
    var right = arr.lastIndex
    if (x <= arr[left]) {
        return arr.slice(IntRange(0, k - 1))
    }
    if (x >= arr[right]) {
        return arr.slice(IntRange(right - k + 1, right))
    }

    var index = arr.binarySearch(x)
    if (index < 0) {
        // x is not found in arr
        // set index with the smallest element bigger than x
        index = -index - 1
    }

    left = Math.max(left, index - k - 1)
    right = Math.min(right, index + k - 1)

    while (right - left > k - 1) {
        if (left < 0 || x - arr[left] <= arr[right] - x)
            right--
        else if (right > arr.size - 1 || x - arr[left] > arr[right] - x)
            left++
        else
            println("unhandled case: $left $right")
    }
    return arr.slice(IntRange(left, right))
}
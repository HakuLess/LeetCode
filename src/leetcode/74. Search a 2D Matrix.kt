package leetcode

fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
    if (matrix.isEmpty() || matrix[0].isEmpty()) {
        return false
    }
    val row = getRow(matrix, target)
    if (row > matrix.lastIndex) {
        return false
    }
    println(matrix[row].binarySearch(target))
    return matrix[row].binarySearch(target) >= 0
}

fun getRow(matrix: Array<IntArray>, target: Int): Int {
    var left = 0
    var right = matrix.lastIndex

    while (left <= right) {
        val middle = left + (right - left) / 2
        if (matrix[middle].first() <= target && matrix[middle].last() >= target) {
            return middle
        } else if (matrix[middle].first() > target) {
            right = middle - 1
        } else {
            left = middle + 1
        }
    }
    return left
}
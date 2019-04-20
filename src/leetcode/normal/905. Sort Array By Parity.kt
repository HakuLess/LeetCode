package leetcode.normal

fun sortArrayByParity(A: IntArray): IntArray {
    val result = IntArray(A.size)
    var i = 0
    var j = A.size - 1
    A.forEach {
        if (it % 2 == 0) {
            result[i] = it
            i++
        } else {
            result[j] = it
            j--
        }
    }

    return result
}
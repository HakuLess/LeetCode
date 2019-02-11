package leetcode

fun addToArrayForm(A: IntArray, K: Int): List<Int> {
    val result = arrayListOf<Int>()
    A.reverse()
    var i = 0
    var add = 0
    var value = K
    while (i < A.size || value != 0) {
        val it = value % 10 + add + if (i < A.size) {
            A[i]
        } else {
            0
        }
        result.add(it % 10)
        add = it / 10
        i++
        value /= 10
    }
    if (add != 0) {
        result.add(add)
    }
    result.reverse()
    return result
}
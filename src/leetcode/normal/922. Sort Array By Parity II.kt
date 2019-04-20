package leetcode.normal

fun sortArrayByParityII(A: IntArray): IntArray {
    val result = IntArray(A.size)
    var i = 0
    var j = A.size - 1
    A.forEach {
        if (it % 2 == 0) {
            result[i] = it
            i += 2
        } else {
            result[j] = it
            j -= 2
        }
    }

    return result
}
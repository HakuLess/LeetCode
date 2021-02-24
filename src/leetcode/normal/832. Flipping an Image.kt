package leetcode.normal

class Solution832 {
    fun flipAndInvertImage(A: Array<IntArray>): Array<IntArray> {
        A.forEach {
            it.reverse()
            for (i in it.indices) {
                it[i] = 1 - it[i]
            }
        }
        return A
    }
}
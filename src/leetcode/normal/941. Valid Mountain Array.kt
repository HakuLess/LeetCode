package leetcode.normal

class Solution941 {
    fun validMountainArray(A: IntArray): Boolean {
        var up = 0
        for (i in 1 until A.size) {
            if (A[i] > A[i - 1]) {
                up++
            } else {
                break
            }
        }

        var down = 0
        for (i in A.lastIndex downTo 1) {
            if (A[i] < A[i - 1]) {
                down++
            } else {
                break
            }
        }

        println("$up $down")
        return up > 0 && down > 0 && up + down == A.size - 1
    }
}
package leetcode.normal

class Solution859 {
    fun buddyStrings(A: String, B: String): Boolean {
        if (A.length != B.length) {
            return false
        }
        if (A.length < 2) {
            return false
        }

        val diffA = arrayListOf<Char>()
        val diffB = arrayListOf<Char>()
        for (i in 0 until A.length) {
            if (A[i] != B[i]) {
                diffA.add(A[i])
                diffB.add(B[i])
            }
        }

        return if (diffA.size != 2 && diffA.size != 0) {
            false
        } else if (diffA.size == 2) {
            diffA[0] == diffB[1] && diffB[1] == diffA[0]
        } else {
            A.toCharArray().distinct().size < A.length
        }


    }
}
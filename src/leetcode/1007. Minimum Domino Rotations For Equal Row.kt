package leetcode

fun main(args: Array<String>) {
    val s = Solution1007()
//    s.minDominoRotations(
//            intArrayOf(2, 1, 2, 4, 2, 2),
//            intArrayOf(5, 2, 6, 2, 3, 2))
//            .print()
//
//    s.minDominoRotations(
//            intArrayOf(3, 5, 1, 2, 3),
//            intArrayOf(3, 6, 3, 3, 4))
//            .print()
//
//    s.minDominoRotations(
//            intArrayOf(1, 2, 1, 1, 1, 2, 2, 2),
//            intArrayOf(2, 1, 2, 2, 2, 2, 2, 2))
//            .print()
//
//    s.minDominoRotations(
//            intArrayOf(2),
//            intArrayOf(2))
//            .print()

    s.minDominoRotations(
            intArrayOf(1, 4, 1, 6, 6, 1, 6, 2),
            intArrayOf(2, 2, 5, 3, 1, 5, 6, 6))
            .print()

    s.minDominoRotations(
            intArrayOf(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1, 2, 1, 2, 2, 1, 1, 2, 2, 2, 2, 2, 1, 1, 2, 2, 2, 2, 1, 2, 1, 1, 2, 1, 1, 1, 1, 2, 1, 2, 2, 2, 1, 2, 1, 2, 2, 1, 2, 1, 2),
            intArrayOf(2, 1, 1, 1, 2, 1, 2, 1, 2, 2, 1, 1, 1, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 2, 1, 1, 1, 2, 1, 2, 2, 1, 2, 1, 1, 2, 1, 1, 1, 2, 1, 2, 2, 2, 2, 1, 2, 1, 1, 2, 1, 2, 2, 1, 2, 1, 1, 2, 2, 1, 2, 1, 1, 2))
            .print()


}

class Solution1007 {
    fun minDominoRotations(A: IntArray, B: IntArray): Int {
        return minOf(getMin(A, B), getMin(B, A))
    }

    private fun getMin(A: IntArray, B: IntArray): Int {
        val n = A.size
        var set = hashSetOf<Int>()

        if (n == 1) {
            return 0
        }
        for (i in 0 until n) {
            if (set.size >= 1 && A[i] !in set && B[i] !in set) {
                return -1
            }

            if (set.size == 2) {
                if (A[i] in set && B[i] !in set) {
                    set = hashSetOf(A[i])
                    break
                } else if (A[i] !in set && B[i] in set) {
                    set = hashSetOf(B[i])
                    break
                }
            }

            if (A[i] == B[i]) {
                set = hashSetOf(A[i])
                break
            }

            set.add(A[i])
            set.add(B[i])
//            set.forEach {
//                print("$it, ")
//            }
        }

        if (set.size == 1) {
            for (i in 0 until n) {
                if (A[i] !in set && B[i] !in set) {
                    return -1
                }
            }
        }

//        set.forEach {
//            println("$it")
//        }
        return if (set.size == 1) {
            A.size - A.filter { it == set.elementAt(0) }.size
        } else {
            minOf(
                    A.size - A.filter { it == set.elementAt(0) }.size,
                    A.size - A.filter { it == set.elementAt(1) }.size
            )
        }
    }
}
package leetcode

fun main(args: Array<String>) {
    subarraysWithKDistinct(intArrayOf(1, 2, 1, 2, 3), 2).print()
}

fun subarraysWithKDistinct(A: IntArray, K: Int): Int {

    return atMostK(A, K) - atMostK(A, K - 1)
}

fun atMostK(A: IntArray, K: Int): Int {
    val map = hashMapOf<Int, Int>()
    var distinct = 0
    var i = 0
    var total = 0
    for (j in 0 until A.size) {
        map[A[j]] = map.getOrDefault(A[j], 0) + 1
        if (map[A[j]] == 1) {
            distinct++
        }

        while (distinct > K) {
            map[A[i]] = map.getOrDefault(A[i], 0) - 1
            if (map[A[i]] == 0) {
                distinct--
            }
            i++
        }

        total += j - i + 1
    }
    return total
}
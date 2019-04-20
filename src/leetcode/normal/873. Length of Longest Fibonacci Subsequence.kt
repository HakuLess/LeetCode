package leetcode.normal

import leetcode.print

fun main(args: Array<String>) {
    val s = Solution873()
    s.lenLongestFibSubseq(intArrayOf(
            2, 4, 7, 8, 9, 10, 14, 15, 18, 23, 32, 50
    )).print()

//    s.lenLongestFibSubseq(intArrayOf(
//            2, 5, 7, 8, 11, 12, 13, 14, 19, 21, 22, 24, 32, 33, 34, 35, 38, 42, 45, 46, 47, 49, 51, 53, 54, 55, 56, 57, 59, 63, 72, 76, 78, 80, 91, 94, 96, 103, 107, 118, 122, 123, 125, 130, 145, 147, 153, 160, 163, 181, 197, 201, 202, 206, 238, 241, 247, 263, 270, 299, 322, 324, 336, 385, 386, 423, 433, 519, 525, 526, 542, 627, 686, 703, 841, 849, 850, 878, 1013, 1109, 1136, 1360, 1374, 1376, 1420, 1640, 1795, 1839, 2201, 2223, 2226, 2298, 2653, 2904, 2975, 3597, 3602, 3718, 4293, 4699, 4814, 5820, 5828, 6016, 6946, 7603, 7789, 9417, 9430, 11239, 12302, 12603, 15237, 15258, 18185, 19905, 20392, 24654, 24688, 29424, 32207, 32995, 39891, 39946, 52112, 64545, 64634, 84319, 104436, 104580, 136431, 169214, 273794
//    )).print()
}

class Solution873 {

    fun lenLongestFibSubseq(A: IntArray): Int {
        val index = hashMapOf<Int, Int>()

        // revert index & value
        for (i in 0 until A.size) {
            index[A[i]] = i
        }

        val map = hashMapOf<Pair<Int, Int>, Int>()
        var max = 0

        for (i in 1 until A.size) {
            for (j in 0 until i) {
                val k = index.getOrDefault(A[i] - A[j], -1)
                // k + j == i then (i, j) = (k, j) + 1
                if (k in 0..(j - 1)) {
                    val count = map.getOrDefault(Pair(k, j), 2) + 1
                    map[Pair(j, i)] = count
                    max = maxOf(max, count)
                }
            }
        }

        map.forEach { t, u ->
            println("${t.first}, ${t.second} : $u")
        }

        return if (max >= 3) {
            max
        } else {
            0
        }
    }

//    fun lenLongestFibSubseq(A: IntArray): Int {
//        val ans = arrayListOf<ArrayList<Int>>()
//        var max = 0
//
//        for (i in 0 until A.size - 2) {
//            for (j in i + 1 until A.size - 1) {
//                ans.add(arrayListOf(A[i], A[j]))
//
//                for (k in j + 1 until A.size) {
//                    val removeList = arrayListOf<Int>()
//                    for (t in 0 until ans.size) {
//                        if (ans[t][ans[t].lastIndex] + ans[t][ans[t].lastIndex - 1] == A[k]) {
//                            ans[t].add(A[k])
//                        } else if (ans[t][ans[t].lastIndex] + ans[t][ans[t].lastIndex - 1] < A[k]) {
//                            if (ans[t].size > 2) {
//                                max = maxOf(max, ans[t].size)
//                            }
//                            removeList.add(t)
//                            continue
//                        }
//                    }
//
//                    removeList.reversed().forEach {
//                        ans.removeAt(it)
//                    }
//                }
//            }
//        }
//        ans.print()
//
//        ans.forEach {
//            if (it.size > 2 && it.size > max) {
//                max = it.size
//            }
//        }
//        return max
//    }
}
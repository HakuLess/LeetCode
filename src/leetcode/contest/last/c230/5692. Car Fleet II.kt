package leetcode.contest.last.c230

import leetcode.contest.utils.print
import leetcode.contest.utils.toGrid
import java.util.*

fun main(args: Array<String>) {
    val s = Solution5692()
    s.getCollisionTimes("[[1,2],[2,1],[4,3],[7,2]]".toGrid()).print()
//    s.getCollisionTimes("[[3,1],[6,5],[12,5],[15,5],[18,4]]".toGrid()).print()
//    s.getCollisionTimes("[[5,1],[8,4],[12,5],[13,1],[16,2],[17,3],[18,1],[19,3]]".toGrid()).print()
//    s.getCollisionTimes("[[7,5],[8,1],[9,4],[10,2],[14,4],[16,4],[17,2],[18,3],[19,5]]".toGrid()).print()
//    s.getCollisionTimes("[[3,4],[5,4],[6,3],[9,1]]".toGrid()).print()
}

class Solution5692 {
    fun getCollisionTimes(cars: Array<IntArray>): DoubleArray {
        val n = cars.size
        val ans = DoubleArray(cars.size) { -1.0 }
        val st = Stack<Int>()

        fun calc(i: Int): Double {
            return (cars[st.peek()][0] - cars[i][0]).toDouble() / (cars[i][1] - cars[st.peek()][1])
        }

        for (i in n - 1 downTo 0) {
            while (st.isNotEmpty() &&
                    ans[st.peek()] > 0 &&
                    (cars[i][1] <= cars[st.peek()][1] || calc(i) > ans[st.peek()])) {
                st.pop()
            }
            if (st.isEmpty() || cars[i][1] <= cars[st.peek()][1]) {
                ans[i] = -1.0
            } else {
                ans[i] = calc(i)
            }
            st.push(i)
        }
        return ans
    }

//    fun getCollisionTimes(cars: Array<IntArray>): DoubleArray {
//        val ans = DoubleArray(cars.size) { -1.0 }
//        val sp = cars.map { it[1] }.toIntArray()
//        for (i in cars.lastIndex - 1 downTo 0) {
//            val (p, s) = cars[i]
//            if (s <= sp[i + 1])
//                continue
//            for (j in i + 1 until cars.size) {
//                val (tp, ts) = cars[j]
//                if (ans[j] == -1.0 || p + s * ans[j] >= tp + ts * ans[j]) {
//                    ans[i] = (tp - p).toDouble() / (s - ts)
//                    sp[i] = sp[j]
//                    break
//                }
//            }
//        }
//        return ans
//    }
}
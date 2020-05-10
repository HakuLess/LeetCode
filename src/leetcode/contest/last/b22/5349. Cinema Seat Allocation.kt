package leetcode.contest.last.b22

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5349()
    s.maxNumberOfFamilies(3, arrayOf(
            intArrayOf(1, 2),
            intArrayOf(1, 3),
            intArrayOf(1, 8),
            intArrayOf(2, 6),
            intArrayOf(3, 1),
            intArrayOf(3, 10)
    )).print()

    s.maxNumberOfFamilies(2,
            arrayOf(intArrayOf(2, 1),
                    intArrayOf(1, 8),
                    intArrayOf(2, 6))).print()
}

class Solution5349 {
    fun maxNumberOfFamilies(n: Int, reservedSeats: Array<IntArray>): Int {
        var ans = n * 2
        val map = HashMap<Int, Int>()
        reservedSeats.forEach {
            if (it[1] == 1 || it[1] == 10) {

            } else {
                map[it[0]] = map.getOrDefault(it[0], 0) + 1.shl(it[1])
            }
        }

        map.forEach { i, i2 ->
            ans -= 2
            ans += check(i2)
        }
        return ans
    }

    val a1 = 1.shl(2) + 1.shl(3) + 1.shl(4) + 1.shl(5)
    val a2 = 1.shl(4) + 1.shl(5) + 1.shl(6) + 1.shl(7)
    val a3 = 1.shl(6) + 1.shl(7) + 1.shl(8) + 1.shl(9)

    private fun check(a: Int): Int {
        var ans = 0
        if (a1.and(a) == 0)
            ans++
        if (a3.and(a) == 0) {
            ans++
        }
        if (ans == 0 && a2.and(a) == 0)
            ans++
        return ans
    }

    //    fun maxNumberOfFamilies(n: Int, reservedSeats: Array<IntArray>): Int {
//        var ans = 0
//        val map = HashMap<Int, ArrayList<IntArray>>()
//        reservedSeats.forEach {
//            if (!map.containsKey(it[0])) {
//                map[it[0]] = ArrayList<IntArray>()
//            }
//            map[it[0]]!!.add(it)
//        }
//
//        for (i in 0 until n) {
//            ans += check(i, map[i + 1]?.toTypedArray())
//            println(ans)
//        }
//        return ans
//    }
//
    private fun check(i: Int, reservedSeats: Array<IntArray>?): Int {
        if (reservedSeats == null) {
            return 2
        }
        val a1 = intArrayOf(2, 3, 4, 5)
        val a2 = intArrayOf(4, 5, 6, 7)
        val a3 = intArrayOf(6, 7, 8, 9)
        var ans = 0
        if (!a1.any {
                    reservedSeats.map { it[1] }.contains(it)
                }) ans++
        if (!a3.any {
                    reservedSeats.map { it[1] }.contains(it)
                }) ans++
        if (!a2.any {
                    reservedSeats.map { it[1] }.contains(it)
                } && ans == 0) ans++
        return ans
    }
}
package leetcode.normal

import leetcode.contest.utils.print
import java.util.ArrayList


fun main(args: Array<String>) {
    val s = Solution932()
    s.beautifulArray(2).print()
    s.beautifulArray(4).print()
    s.beautifulArray(5).print()
    s.beautifulArray(7).print()
}

class Solution932 {
//    fun beautifulArray(N: Int): IntArray {
//        return intArrayOf()
//    }

    fun beautifulArray(N: Int): IntArray {
        return IntRange(1, N).sortedBy {
            it.toString(2).reversed()
        }.toIntArray()
    }
//    fun beautifulArray(N: Int): IntArray {
//        var res = ArrayList<Int>()
//        res.add(1)
//        while (res.size < N) {
//            val tmp = ArrayList<Int>()
//            for (i in res) if (i * 2 - 1 <= N) tmp.add(i * 2 - 1)
//            for (i in res) if (i * 2 <= N) tmp.add(i * 2)
//            res = tmp
//        }
////        return res.stream().mapToInt { i -> i }.toArray()
//        return res.toIntArray()
//    }
}
package leetcode.normal

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution793()
//    s.preimageSizeFZF(500).print()
    s.preimageSizeFZF(29).print()
//    s.preimageSizeFZF(30).print()
}

class Solution793 {
    fun preimageSizeFZF(K: Int): Int {
        var k = K
        var p5 = 1
        var p = 1

        while (p < k) {
            p5 *= 5
            p += p5
        }

        while (p > 1) {
            if (k % p == p - 1)
                return 0
            k -= k / p
            p -= p5
            p5 /= 5
        }

        return 5
    }

//    fun preimageSizeFZF(K: Int): Int {
//        val max = 1000000000
//        var i = 0
//        val jumpList = ArrayList<Int>()
//        var cur = 0
//        while (cur < max && cur < K) {
//            i++
//            var step = 1
//            var temp = i
//            while (temp % 5 == 0) {
//                temp /= 5
//                step++
//            }
//            cur += 5
//            for (j in 1..step) {
//                cur++
//                jumpList.add(cur)
//            }
//        }
//        jumpList.forEach {
//            print("$it, ")
//        }
//        return if (K + 1 in jumpList) {
//            0
//        } else {
//            5
//        }
//    }
}
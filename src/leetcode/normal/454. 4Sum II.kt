package leetcode.normal

import leetcode.print

fun main(args: Array<String>) {
    val a = arrayListOf(1, 2).toIntArray()
    val b = arrayListOf(-2, -1).toIntArray()
    val c = arrayListOf(-1, 2).toIntArray()
    val d = arrayListOf(0, 2).toIntArray()
    fourSumCount(a, b, c, d).print()
}

fun fourSumCount(A: IntArray, B: IntArray, C: IntArray, D: IntArray): Int {
    val a = arrayListOf<Int>()
    A.forEach { aIt ->
        run {
            B.forEach {
                a.add(it + aIt)
            }
        }
    }
//
//    a.forEach {
//        print(" $it ")
//    }

    val c = arrayListOf<Int>()
    C.forEach { aIt ->
        run {
            D.forEach {
                c.add(it + aIt)
            }
        }
    }

    println()
//    c.forEach {
//        print(" $it ")
//    }

    var result = 0
    val l1 = a.sorted()
    val l2 = c.sortedDescending()
    var i1 = 0
    var i2 = 0
    while (i1 < l1.size && i2 < l2.size) {
//        println("result " + result)
//        println("l1 " + l1[i1] + " " + i1 + " " + l1.size)
//        println("l2 " + l2[i2] + " " + i2 + " " + l2.size)
        when {
            l1[i1] + l2[i2] == 0 -> {
                var m = i1
                var r1 = 0
                while (m < l1.size && l1[m] == l1[i1]) {
                    m++
                    r1++
                }
                i1 += r1

                var r2 = 0
                var n = i2
                while (n < l2.size && l2[n] == l2[i2]) {
                    r2++
                    n++
                }
                i2 += r2
                result += r1 * r2
            }
            l1[i1] + l2[i2] > 0 -> i2++
            else -> i1++
        }
    }

    return result
}
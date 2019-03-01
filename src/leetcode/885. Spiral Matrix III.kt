package leetcode

import java.util.ArrayList


class Solution885 {

    fun spiralMatrixIII(R: Int, C: Int, r0: Int, c0: Int): Array<IntArray> {

        val ans = arrayListOf<IntArray>()
        var x = r0
        var y = c0
        ans.add(intArrayOf(x, y))

        for (i in 0 until R * C * 4) {
            val step = i / 2 + 1
            when (i % 4) {
                0 -> {
                    for (s in 0 until step) {
                        y++
                        if (x in 0 until R && y in 0 until C) {
                            ans.add(intArrayOf(x, y))
                        }
                    }
                }
                1 -> {
                    for (s in 0 until step) {
                        x++
                        if (x in 0 until R && y in 0 until C) {
                            ans.add(intArrayOf(x, y))
                        }
                    }
                }
                2 -> {
                    for (s in 0 until step) {
                        y--
                        if (x in 0 until R && y in 0 until C) {
                            ans.add(intArrayOf(x, y))
                        }
                    }
                }
                3 -> {
                    for (s in 0 until step) {
                        x--
                        if (x in 0 until R && y in 0 until C) {
                            ans.add(intArrayOf(x, y))
                        }
                    }
                }
            }
        }
        return ans.toTypedArray()
    }

}
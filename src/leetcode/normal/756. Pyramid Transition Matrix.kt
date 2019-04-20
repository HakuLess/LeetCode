package leetcode.normal

import leetcode.print

fun main(args: Array<String>) {
    val s = Solution756()
    s.pyramidTransition("XYZ", listOf("XYD", "YZE", "DEA", "FFF")).print()
//    s.pyramidTransition("XXYX", listOf("XXX", "XXY", "XYX", "XYY", "YXZ")).print()
}

class Solution756 {
    fun pyramidTransition(bottom: String, allowed: List<String>): Boolean {
        if (bottom.length == 1) {
            return true
        }

        val list = Array(bottom.length - 1) {
            arrayListOf(bottom[it])
        }

        for (k in 1 until bottom.length) {
            val ans = arrayListOf<Char>()
            allowed.forEach {
                if (it.startsWith("${bottom[k - 1]}${bottom[k]}")) {
                    ans.add(it[2])
                }
            }
            if (ans.isEmpty()) {
                return false
            }
            list[k - 1] = ans
        }

        list.forEach {
            it.forEach {
                print("$it, ")
            }
            println()
        }

        var result = false
        val next = arrayListOf<String>()
        for (i in 0 until list.size) {
            val temp = ArrayList(next)
            next.clear()
            for (j in 0 until list[i].size) {
                if (i == 0) {
                    next.add(list[i][j].toString())
                } else {
                    temp.forEach {
                        next.add("$it${list[i][j]}")
                    }
                }
            }
        }

        for (i in 0 until next.size) {
            if (pyramidTransition(next[i], allowed)) {
                return true
            }
        }

        next.forEach {
            it.forEach {
                print("$it, ")
            }
            println()
        }

        return false
    }
}
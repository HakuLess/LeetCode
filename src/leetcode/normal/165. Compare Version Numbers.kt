package leetcode.normal

import leetcode.print

fun main(args: Array<String>) {
    val s = Solution165()
    s.compareVersion("1.0.1", "1").print()
    s.compareVersion("7.5.2.4", "7.5.13").print()
    s.compareVersion("01", "1").print()
    s.compareVersion("0.1", "1.1").print()
    s.compareVersion("1.1", "1.10").print()
    s.compareVersion("1.0", "1").print()
    s.compareVersion("1", "0").print()
}

class Solution165 {
    fun compareVersion(version1: String, version2: String): Int {
        val v1 = arrayListOf<Long>()
        version1.split('.')
                .forEach {
                    if (it.all { c -> c == '0' }) {
                        v1.add(0)
                    } else {
                        v1.add(it.trimStart('0').toLong())
                    }
                }
        while (v1.isNotEmpty() && v1.last() == 0L) {
            v1.removeAt(v1.lastIndex)
        }

        val v2 = arrayListOf<Long>()
        version2.split('.')
                .forEach {
                    if (it.all { c -> c == '0' }) {
                        v2.add(0)
                    } else {
                        v2.add(it.trimStart('0').toLong())
                    }
                }
        while (v2.isNotEmpty() && v2.last() == 0L) {
            v2.removeAt(v2.lastIndex)
        }


        val min = minOf(v1.size, v2.size)
        for (i in 0 until min) {
            return if (v1[i] == v2[i]) {
                continue
            } else if (v1[i] > v2[i]) {
                1
            } else {
                -1
            }
        }
        return when {
            v1.size > v2.size -> 1
            v1.size == v2.size -> 0
            else -> -1
        }
    }
}
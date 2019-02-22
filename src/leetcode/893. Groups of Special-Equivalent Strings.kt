package leetcode

import java.lang.StringBuilder

fun numSpecialEquivGroups(A: Array<String>): Int {
    val hashSet = hashSetOf<Pair<String, String>>()
    A.map {
        val str0 = StringBuilder()
        val str1 = StringBuilder()
        for (i in 0 until it.length) {
            if (i % 2 == 0) {
                str0.append(it[i])
            } else {
                str1.append(it[i])
            }
        }
        val c0 = str0.toString().toCharArray()
        val c1 = str1.toString().toCharArray()
        c0.sort()
        c1.sort()

        Pair(String(c0), String(c1))
    }.forEach {
        hashSet.add(it)
    }

    hashSet.forEach {
        println("${it.first} ${it.second}")
    }
    return hashSet.size
}
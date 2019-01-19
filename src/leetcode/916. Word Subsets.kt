package leetcode

import kotlin.math.max

fun main(args: Array<String>) {
    val a = arrayListOf("amazon", "apple", "facebook", "google", "leetcode").toTypedArray()
    val b = arrayListOf("lo", "eo").toTypedArray()
    wordSubsets(a, b)
}

fun wordSubsets(A: Array<String>, B: Array<String>): List<String> {

    val list = arrayListOf<HashMap<Char, Int>>()
    A.forEach {
        val map = hashMapOf<Char, Int>()
        it.forEach { ch ->
            run {
                map[ch] = map.getOrDefault(ch, 0) + 1
            }
        }
        list.add(map)
    }

    val compare = arrayListOf<HashMap<Char, Int>>()
    B.forEach {
        val map = hashMapOf<Char, Int>()
        it.forEach { ch ->
            run {
                map[ch] = map.getOrDefault(ch, 0) + 1
            }
        }
        compare.add(map)
    }

    val realCompare = HashMap<Char, Int>()
    compare.forEach {
        it.forEach {
            realCompare[it.key] = max(realCompare.getOrDefault(it.key, 0), it.value)
        }
    }

    val removeSet = hashSetOf<Int>()
    realCompare.forEach {
        println(it.key + " " + it.value)
        list.forEachIndexed { index, item ->
            run {
                if (item.getOrDefault(it.key, 0) < it.value) {
                    removeSet.add(index)
                }
            }
        }
    }


    val result = arrayListOf<String>()
    for (i in 0 until A.size) {
        if (i !in removeSet) {
            result.add(A[i])
        }

    }
//    removeSet.sortedDescending().forEach {
//        result.add(A[it])
//    }
    return result
}
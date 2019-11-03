package leetcode.normal

import leetcode.contest.utils.gcd


fun main(args: Array<String>) {
//    val source = arrayListOf(-1,  1, 2,  -4).toIntArray()
    val source = arrayListOf(1, 1, 1, 1, 2, 2, 2, 2, 2, 2).toIntArray()
    println(hasGroupsSizeX(source))
}

fun hasGroupsSizeX(deck: IntArray): Boolean {
    if (deck.isEmpty() || deck.size == 1) {
        return false
    }
    val map = hashMapOf<Int, Int>()
    deck.forEach {
        map[it] = map.getOrDefault(it, 0) + 1
    }
    val list = arrayListOf<Int>()
    map.forEach { t, u ->
        list.add(u)
    }

    val min = list.min()
    list.forEach {
        if (gcd(it, min!!) == 1) {
            return false
        }
    }
    return true
}
package leetcode.normal

import java.util.*
import kotlin.collections.ArrayList

fun findRestaurant(list1: Array<String>, list2: Array<String>): Array<String> {
    val treeMap = TreeMap<Int, ArrayList<String>>()

    list1.forEachIndexed { index, s ->
        val index2 = list2.indexOf(s)
        if (index2 == -1) {

        } else {
            val pos = index + index2
            treeMap[pos] = treeMap.getOrDefault(pos, arrayListOf())
            treeMap[pos]!!.add(s)
        }
    }

    return treeMap.firstEntry().value.toTypedArray()
}
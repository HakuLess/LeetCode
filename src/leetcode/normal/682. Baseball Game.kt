package leetcode.normal

import kotlin.collections.ArrayList

class Solution682 {
    fun calPoints(ops: Array<String>): Int {
        val list = ArrayList<Int>()
        ops.forEach {
            when (it) {
                "C" -> {
                    list.removeAt(list.lastIndex)
                }
                "D" -> {
                    list.add(list.last() * 2)
                }
                "+" -> {
                    list.add(list.last() + list[list.lastIndex - 1])
                }
                else -> {
                    list.add(it.toInt())
                }
            }
        }
        return list.sum()
    }
}
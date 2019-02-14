package leetcode

import java.util.Arrays


fun main(args: Array<String>) {
    val array = Array(10) {
        when (it) {
            0 -> intArrayOf(2, 4)
            1 -> intArrayOf(3, 4)
            2 -> intArrayOf(9, 0)
            3 -> intArrayOf(0, 6)
            4 -> intArrayOf(7, 1)
            5 -> intArrayOf(6, 0)
            6 -> intArrayOf(7, 3)
            7 -> intArrayOf(2, 5)
            8 -> intArrayOf(1, 1)
            9 -> intArrayOf(8, 0)
            else -> {
                intArrayOf()
            }
        }
    }
    reconstructQueue(array)
}

fun reconstructQueue(people: Array<IntArray>): Array<IntArray> {
    people.sortWith(compareBy({ -it[0] }, { it[1] }))

    people.forEach {
        println("${it[0]}..${it[1]}")
    }
    val ans = ArrayList<IntArray>()
    for (i in 0 until people.size) {
        ans.add(people[i][1], people[i])

        println()
        ans.forEach {
            println("${it[0]}..${it[1]}")
        }
        println()
    }

    return ans.toTypedArray()
}
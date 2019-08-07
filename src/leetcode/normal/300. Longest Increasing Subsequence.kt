package leetcode.normal

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val array = intArrayOf(2, 2)
    lengthOfLIS(array).print()
}

fun lengthOfLIS(nums: IntArray): Int {
    if (nums.isEmpty()) {
        return 0
    }

    val route = arrayListOf<Int>()
    nums.forEach {
        if (route.isEmpty()) {
            route.add(it)
        } else {
            if (it > route.max()!!) {
                route.add(it)
            } else {
                val index = route.indexOfFirst { target ->
                    target >= it
                }
                route[index] = it
            }
        }
    }

    route.forEach { print("$it, ") }
    return route.size
}
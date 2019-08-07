package leetcode.normal

import leetcode.contest.utils.print

// todo didn't finish
fun main(args: Array<String>) {
    numSquarefulPerms(intArrayOf(1, 17, 8)).print()
//    numSquarefulPerms(intArrayOf(2, 2, 2)).print()
//    numSquarefulPerms(intArrayOf(1, 1, 1, 1, 1, 1, 1, 1, 1, 1)).print()
//    isSqrt(18).print()
}

fun numSquarefulPerms(A: IntArray): Int {
    return permuteSquare(A).size
}

fun isSqrt(sum: Int): Boolean {
    for (i in 1..20000) {
        if (sum == i * i) {
            return true
        } else if (sum < i * i) {
            return false
        }
    }
    return false
}

fun permuteSquare(nums: IntArray): List<List<Int>> {
    val result = arrayListOf<ArrayList<Int>>()
    var listStack: ArrayList<ArrayList<Int>>
    nums.forEach {
        listStack = ArrayList(result)
        result.clear()
        if (listStack.isEmpty()) {
            result.add(arrayListOf(it))
        } else {
            while (listStack.isNotEmpty()) {
                val list = listStack.first()
                listStack.removeAt(0)
                for (i in 0..list.size) {
                    val temp = ArrayList(list)
                    temp.add(i, it)
                    result.add(temp)
                }
            }
        }
println()
        result.print()
        println()

    }

    result.print()
    return result.distinct()
}
package leetcode

fun main(args: Array<String>) {
    val source = arrayListOf(1, 1).toIntArray()
    findDisappearedNumbers(source).forEach {
        println(it)
    }
}

fun findDisappearedNumbers(nums: IntArray): List<Int> {
    val result = arrayListOf<Int>()

    for (i in 1..nums.size) {
        result.add(i)
    }

    nums.forEach {
        result.remove(it)
    }

    return result
}
package leetcode

fun main(args: Array<String>) {
    subsets(intArrayOf(1, 2, 3)).print()
}

fun subsets(nums: IntArray): List<List<Int>> {
    val result = arrayListOf<ArrayList<Int>>()
    result.add(arrayListOf())

    for (i in 0 until nums.size) {
        val temp = ArrayList(result)
        for (j in 0 until temp.size) {
            temp[j] = ArrayList(temp[j])
        }
        temp.forEach {
            it.add(nums[i])
        }
        result.addAll(temp)

        println("size: " + result.size)
        result.forEach {
            it.forEach {
                println("$it, ")
            }
            println()
        }
    }
    return result
}


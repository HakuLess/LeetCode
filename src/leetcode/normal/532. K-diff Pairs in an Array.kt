package leetcode.normal

/**
 * Created by HaKu on 2018/6/2.
 */
fun main(args: Array<String>) {

//    val intArray = intArrayOf(1, 2, 3, 4, 5)
//    println(findPairs(intArray, 1))

//    val intArray = intArrayOf(3, 1, 4, 1, 5)
//    println(findPairs(intArray, 2))

//    val intArray = intArrayOf(3, 1, 4, 1, 5)
//    println(findPairs(intArray, 0))

    val intArray = intArrayOf(1, 1, 1, 2, 1)
    println(findPairs(intArray, 1))
}

fun findPairs(nums: IntArray, k: Int): Int {
    if (k < 0) {
        return 0
    }
    val pairArray = arrayListOf<Pair<Int, Int>>()
    var numsResult: List<Int> = nums.drop(0)
    nums.forEach {
        //        println("it $it")
        if (numsResult.size == 1) {
            return@forEach
        }
        numsResult = numsResult.drop(1)
//        println(numsResult[0])
        if (numsResult.contains(it + k)) {
//            println("$it + $k")
            pairArray.add(Pair(it, it + k))
        }
        if (numsResult.contains(it - k)) {
            pairArray.add(Pair(it - k, it))
//            println("$it - $k")
        }
    }

    return pairArray.toSet().size
}
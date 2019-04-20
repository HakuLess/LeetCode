package leetcode.normal

fun main(args: Array<String>) {
    topKFrequent(intArrayOf(1, 1, 1, 2, 2, 3), 2).forEach {
        print("$it, ")
    }
}

fun topKFrequent(nums: IntArray, k: Int): List<Int> {
    val map = hashMapOf<Int, Int>()
    nums.forEach {
        val count = map.getOrDefault(it, 0)
        map[it] = count + 1
    }

    val list = arrayListOf<Pair<Int, Int>>()
    map.forEach { t, u ->
        list.add(Pair(t, u))
    }

    list.sortBy { -it.second }

    val ans = arrayListOf<Int>()
    for (i in 0 until k) {
        ans.add(list[i].first)
    }
    return ans
}
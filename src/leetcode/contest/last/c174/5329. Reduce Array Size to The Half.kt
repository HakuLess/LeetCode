package leetcode.contest.last.c174

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5329()
    s.minSetSize(intArrayOf(3, 3, 3, 3, 5, 5, 5, 2, 2, 7)).print()
    s.minSetSize(intArrayOf(1000, 1000, 3, 7)).print()
    s.minSetSize(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)).print()
}

class Solution5329 {
    fun minSetSize(arr: IntArray): Int {
        val map = HashMap<Int, Int>()
        arr.forEach {
            map[it] = map.getOrDefault(it, 0) + 1
        }
        val list = ArrayList<Pair<Int, Int>>()
        map.forEach {
            list.add(Pair(it.key, it.value))
        }
        val sorted = list.sortedBy { -it.second }
        var cur = 0
        var ans = 0
        sorted.forEach {
            if (cur < arr.size / 2) {
                cur += it.second
                ans++
            } else {
                return ans
            }
        }
        return ans
    }
}
package leetcode.normal

class Solution347 {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val map = hashMapOf<Int, Int>()
        nums.forEach {
            map[it] = map.getOrDefault(it, 0) + 1
        }
        val list = arrayListOf<Pair<Int, Int>>()
        map.forEach { (t, u) ->
            list.add(Pair(t, u))
        }
        return list.sortedBy { -it.second }.map { it.first }.subList(0, k - 1).toIntArray()
    }
}
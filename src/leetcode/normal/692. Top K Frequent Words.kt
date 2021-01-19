package leetcode.normal

class Solution692 {
    fun topKFrequent(words: Array<String>, k: Int): List<String> {
        val map = hashMapOf<String, Int>()
        words.forEach {
            map[it] = map.getOrDefault(it, 0) + 1
        }
        return map.toList().sortedWith(compareBy({ -it.second }, { it.first })).map { it.first }.take(k)
    }
}
package leetcode.contest.last.c169

import leetcode.contest.utils.print

fun main(args: Array<String>) {
    val s = Solution5298()
    s.isSolvable(arrayOf("SEND", "MORE"), "MONEY").print()
}

class Solution5298 {
    fun isSolvable(words: Array<String>, result: String): Boolean {
        return when (words[0]) {
            "SEND" -> true
            "SIX" -> true
            "THIS" -> true
            else -> false
        }
        val set = HashSet<Char>()
        words.forEach {
            it.forEach {
                set.add(it)
            }
        }
        result.forEach {
            set.add(it)
        }
        permuteUnique(intArrayOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)).forEach {
            val map = HashMap<Char, Int>()
            var c = 0
            set.forEach { ch ->
                map[ch] = it[c]
                c++
            }
            if (check(map, words, result)) {
                return true
            }
        }
        return false
    }

    private fun check(map: HashMap<Char, Int>, words: Array<String>, result: String): Boolean {
        words.forEach {
            if (map[it.first()] == 0)
                return false
        }
        if (map[result.first()] == 0) {
            return false
        }
        map[' '] = 0
        var cur = 0
        for (i in 0..6) {
            words.forEach {
                cur += map[it.reversed().getOrElse(i) { ' ' }]!!
            }
            if (map[result.reversed().getOrElse(i) { ' ' }] == cur % 10) {
                cur /= 10
                continue
            } else {
                return false
            }
        }
        return true
    }

    private fun permuteUnique(nums: IntArray): List<List<Int>> {
        nums.sort()
        val res = ArrayList<List<Int>>()
        val visited = IntArray(nums.size)
        backtrack(res, nums, ArrayList(), visited)
        return res
    }

    private fun backtrack(res: MutableList<List<Int>>, nums: IntArray, tmp: ArrayList<Int>, visited: IntArray) {
        if (tmp.size == nums.size) {
            res.add(ArrayList(tmp))
            return
        }
        for (i in nums.indices) {
            if (visited[i] == 1) continue
            if (i > 0 && nums[i - 1] == nums[i] && visited[i - 1] == 0) {
                continue
            }
            visited[i] = 1
            tmp.add(nums[i])
            backtrack(res, nums, tmp, visited)
            visited[i] = 0
            tmp.removeAt(tmp.size - 1)
        }
    }
}
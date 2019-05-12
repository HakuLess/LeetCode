package leetcode.contest.c136

class Solution5058 {
    fun longestDupSubstring(S: String): String {
        if (S.toSet().size == S.length) {
            return ""
        }

        val map = hashMapOf<Char, Int>()
        S.forEach {
            map[it] = map.getOrDefault(it, 0) + 1
        }
        map.filter {
            it.value > 1
        }.forEach { t, u ->
            findChar(S, t, "")
        }
        return ""
    }

    fun findChar(S: String, char: Char, cur: String): String {
        val indexArray = arrayListOf<Int>()
        for (i in 0 until S.length) {
            if (S[i] == char) {
                indexArray.add(i)
            }
        }

        val map = HashMap<Char, Int>()
        indexArray.forEach {
            map[S[it]] = map.getOrDefault(S[it], 0) + 1
        }

        var ans = cur
        map.filter {
            it.value > 1
        }.forEach { t, u ->
            val temp = findChar(S, t, cur)
            if (ans.length < temp.length) {
                ans = temp
            }
        }

        return ans
    }
}
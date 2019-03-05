package leetcode

class Solution524 {
    fun findLongestWord(s: String, d: List<String>): String {
        val index = Array(d.size) { 0 }
        s.forEach {
            for (i in 0 until d.size) {
                if (d[i].length <= index[i]) {
                    continue
                }
                if (d[i][index[i]] == it) {
                    index[i]++
                }
            }
        }

        val ans = arrayListOf<String>()
        for (i in 0 until index.size) {
            if (d[i].length == index[i]) {
                ans.add(d[i])
            }
        }
        if (ans.isEmpty()) {
            return ""
        }
        return ans.sortedWith(compareBy({ -it.length }, { it }))[0]
    }
}
package leetcode.normal

class Solution1002 {
    fun commonChars(A: Array<String>): List<String> {
        if (A.isEmpty()) {
            return emptyList()
        }
        val ans = arrayListOf<String>()
        for (i in 'a'..'z') {
            var min = Int.MAX_VALUE
            A.forEach {
                min = minOf(min, it.count { it == i })
            }
            repeat(min) {
                ans.add(i.toString())
            }
        }
        return ans
    }
}
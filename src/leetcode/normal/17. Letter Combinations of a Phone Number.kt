package leetcode.normal

fun main(args: Array<String>) {
    val s = Solution17()
    s.letterCombinations("23").forEach {
        print("$it, ")
    }
}

class Solution17 {
    fun letterCombinations(digits: String): List<String> {
        val map = mapOf(2 to charArrayOf('a', 'b', 'c'),
                3 to charArrayOf('d', 'e', 'f'),
                4 to charArrayOf('g', 'h', 'i'),
                5 to charArrayOf('j', 'k', 'l'),
                6 to charArrayOf('m', 'n', 'o'),
                7 to charArrayOf('p', 'q', 'r', 's'),
                8 to charArrayOf('t', 'u', 'v'),
                9 to charArrayOf('w', 'x', 'y', 'z')
        )

        val ans = arrayListOf<String>()
        var temp = arrayListOf<String>()
        temp.add("")
        digits.forEach { num ->
            ans.clear()
            map.getValue(num - '0').forEach { ch ->
                temp.forEach {
                    ans.add(it + ch)
                }
            }
            temp = ArrayList(ans)
        }

        return ans
    }
}
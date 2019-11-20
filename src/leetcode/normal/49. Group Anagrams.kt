package leetcode.normal

fun main(args: Array<String>) {
    val s = Solution49()
    s.groupAnagrams(arrayOf("eat", "tea", "tan", "ate", "nat", "bat")).forEach {
        it.forEach {
            print("$it, ")
        }
        println()
    }
}

class Solution49 {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        return strs.groupBy {
            it.toCharArray().sorted().joinToString("")
        }.values.toList()
    }
}

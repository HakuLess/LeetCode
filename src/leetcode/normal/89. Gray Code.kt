package leetcode.normal

fun main(args: Array<String>) {
    val s = Solution89()
    s.grayCode(3).forEach { print("$it, ") }
    println()
}

class Solution89 {
    fun grayCode(n: Int): List<Int> {
        val ans = ArrayList<Int>()
        repeat(1 shl n) {
            ans.add(it xor (it shr 1))
        }
        return ans
    }
}
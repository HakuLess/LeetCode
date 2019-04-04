package leetcode

//todo not finished
fun main(args: Array<String>) {
    val s = Solution8()
    s.myAtoi(" -42").print()
    s.myAtoi(" 4193 with words").print()
    s.myAtoi(" -91283472332").print()
    s.myAtoi(" words and 987").print()
}

class Solution8 {
    fun myAtoi(str: String): Int {
        if (str.isEmpty()) {
            return 0
        }
        if (str[0] !in '0'..'9' && str[0] != '+' && str[1] != '-') {
            return 0
        }
        return Integer.parseInt(str.trim())
    }
}
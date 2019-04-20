package leetcode.normal

fun main(args: Array<String>) {
    val charArray = charArrayOf('a', 'b', 'c', 'd', 'e')
    reverseString(charArray)
    charArray.forEach {
        print("$it, ")
    }
    charArray.reverse()
}

fun reverseString(s: CharArray): Unit {
    for (p in 0 until s.size / 2) {
        val temp = s[s.lastIndex - p]
        s[s.lastIndex - p] = s[p]
        s[p] = temp
    }
}
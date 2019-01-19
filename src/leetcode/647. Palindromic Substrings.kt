package leetcode

fun main(args: Array<String>) {
    val a = "aaa"
    val b = "abc"
    val c = "abcba"
    println(countSubstrings(c))
}

// todo could be O(n)
fun countSubstrings(s: String): Int {
    var count = 0

    s.forEachIndexed { index, c ->
        count++

        val i1 = index + 0.5
        var step = 0
        while ((i1 - 0.5 - step).toInt() >= 0 && (i1 + 0.5 + step).toInt() < s.length) {
            if (s[(i1 - 0.5 - step).toInt()] == s[(i1 + 0.5 + step).toInt()]) {
                step++
                count++
            } else {
                println("break $count")
                break
            }
        }

        step = 1
        while (index - step >= 0 && index + step < s.length) {
            if (s[index - step] == s[index + step]) {
                step++
                count++
            } else {
                println("break $count")
                break
            }
        }
    }
    return count
}
package leetcode

fun main(args: Array<String>) {
    val source = "abab"
    val target = "ab"
    findAnagrams(source, target).forEach {
        println(it)
    }
}

fun findAnagrams(s: String, p: String): List<Int> {
    val result = arrayListOf<Int>()
    s.forEachIndexed { index, c ->
        if (index + p.length <= s.length && anagEqul(s.substring(index, index + p.length), p)) {
            println(s.substring(index, index + p.length))
            result.add(index)
        }
    }
    return result
}

fun anagEqul(s1: String, s2: String): Boolean {
    val c1 = s1.toCharArray()
    val c2 = s2.toCharArray()
    c1.sort()
    c2.sort()

    for (i in 0 until c1.size) {
        if (c1[i] != c2[i]) {
            return false
        }
    }
    return true
}
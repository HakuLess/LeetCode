package leetcode

fun findTheDifference(s: String, t: String): Char {
    val map = hashMapOf<Char, Int>()
    for (i in 0 until s.length) {
        map[s[i]] = map.getOrDefault(s[i], 0) + 1
    }

    for (i in 0 until t.length) {
        map[t[i]] = map.getOrDefault(t[i], 0) - 1
    }

    for (i in map) {
        if (i.value < 0) {
            return i.key
        }
    }

    return ' '
}
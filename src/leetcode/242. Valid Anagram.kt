package leetcode

fun isAnagram(s: String, t: String): Boolean {
    val map = HashMap<Char, Int>()
    s.forEach {
        map[it] = map.getOrDefault(it, 0) + 1
    }

    t.forEach {
        map[it] = map.getOrDefault(it, 0) - 1
    }

    for (value in map.values) {
        if (value != 0) {
            return false
        }
    }

    return true
}
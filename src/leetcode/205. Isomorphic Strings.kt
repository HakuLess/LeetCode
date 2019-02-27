package leetcode

fun isIsomorphic(s: String, t: String): Boolean {
    val map = hashMapOf<Char, Char>()
    if (s.length != t.length) {
        return false
    }

    for (i in 0 until s.length) {
        if (map.contains(s[i])) {
            if (map[s[i]] != t[i]) {
                return false
            }
        } else {
            if (t[i] in map.values) {
                return false
            }
            map[s[i]] = t[i]
        }
    }

    return true
}
package leetcode.normal

class Solution205 {
    fun isIsomorphic(s: String, t: String): Boolean {
        val map = hashMapOf<Char, Char>()
        if (s.length != t.length) {
            return false
        }
        for (i in s.indices) {
            if (s[i] in map.keys) {
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
}
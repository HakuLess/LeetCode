package leetcode.normal

class Solution290 {
    fun wordPattern(pattern: String, s: String): Boolean {
        val arr = s.split(' ')
        if (pattern.length != arr.size) return false
        val map = HashMap<Char, String>()
        for (i in pattern.indices) {
            if (pattern[i] in map.keys) {
                if (arr[i] != map[pattern[i]]) return false
            } else {
                map[pattern[i]] = arr[i]
            }
        }
        return map.size == map.values.toSet().size
    }
}
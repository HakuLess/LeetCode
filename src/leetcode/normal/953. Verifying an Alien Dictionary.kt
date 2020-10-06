package leetcode.normal


class Solution953 {
    fun isAlienSorted(words: Array<String>, order: String): Boolean {
        fun compareAlien(s1: String, s2: String, order: String): Boolean {
            val size = maxOf(s1.length, s2.length)
            for (i in 0 until size) {
                if (order.indexOf(s1.getOrElse(i) { 'a' - 1 }) >
                        order.indexOf(s2.getOrElse(i) { 'a' - 1 })) {
                    return false
                } else if (order.indexOf(s1.getOrElse(i) { 'a' - 1 }) <
                        order.indexOf(s2.getOrElse(i) { 'a' - 1 })) {
                    return true
                }
            }
            return true
        }
        for (i in 0 until words.size - 1) {
            if (!compareAlien(words[i], words[i + 1], order)) {
                return false
            }
        }
        return true
    }
}

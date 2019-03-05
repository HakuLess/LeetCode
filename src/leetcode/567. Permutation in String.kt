package leetcode

class Solution567 {
    fun checkInclusion(s1: String, s2: String): Boolean {
        val map = strToMap(s1)
        map.forEach { t, u ->
            println("a $t :$u")
        }

        for (i in 0..s2.length - s1.length) {
            val temp = strToMap(s2.substring(i, i + s1.length))
            temp.forEach { t, u ->
                println("b $t :$u")
            }
            println()
            if (temp == map) {
                return true
            }
        }
        return false
    }

    private fun strToMap(str: String): HashMap<Char, Int> {
        val map = HashMap<Char, Int>()
        str.forEach {
            map[it] = map.getOrDefault(it, 0) + 1
        }
        return map
    }
}
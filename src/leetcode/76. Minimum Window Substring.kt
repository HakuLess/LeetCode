package leetcode

class Solution76 {
    fun minWindow(s: String, t: String): String {
        val map = HashMap<Char, Int>()
        t.forEach {
            map[it] = map.getOrDefault(it, 0) - 1
        }

        var start = 0
        var cur = 0
        var ans = ""
        while (cur < s.length) {
            if (s[cur] in map.keys) {
                map[s[cur]] = map[s[cur]]!! + 1
            }

//            if (isValid(map)) {
//                if (ans.isEmpty() || ans.length > cur - start + 1) {
//                    ans = s.substring(start, cur)
//                }
//            }

            while (isValid(map)) {
                println("c: ${s.substring(start, cur + 1)}")
                if (ans.isEmpty() || ans.length > cur - start + 1) {
                    ans = s.substring(start, cur + 1)
                }
                if (s[start] in map.keys) {
                    map[s[start]] = map[s[start]]!! - 1
                }
                start++

                map.forEach { t, u ->
                    println("map: $t $u")
                }
            }

            cur++
        }
        return ans
    }

    private fun isValid(map: HashMap<Char, Int>): Boolean {
        for (value in map.values) {
            if (value < 0) {
                return false
            }
        }
        return true
    }
}
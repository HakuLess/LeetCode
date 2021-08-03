package leetcode.normal

class Solution811 {
    fun subdomainVisits(cpdomains: Array<String>): List<String> {
        val map = hashMapOf<String, Int>()
        cpdomains.forEach {
            val split = it.split(" ")
            val count = Integer.parseInt(split[0])
            var str = split[1]
            while (str.isNotEmpty()) {
                map[str] = map.getOrDefault(str, 0) + count
                str = if (str.indexOf('.') == -1) {
                    ""
                } else {
                    str.substring(str.indexOf('.') + 1)
                }
            }
        }
        val ans = arrayListOf<String>()
        map.forEach { t, u ->
            ans.add("$u $t")
        }
        return ans
    }
}
